/**
 * firebaseの初期認証
 * 認証NGの場合はログイン画面に遷移する
 * ここを非同期処理化した方が良い
 * */
firebase.auth().onAuthStateChanged( (user) => {
	if(!user) {
		// firebase未ログインの場合
		window.location.href = 'login.html';
	}
	else {
		console.log(user);
		console.table(user);
		// 自分のuidのタスク取得
		firebase.auth().currentUser.getIdToken(/* forceRefresh */ true).then(getTasks);
	}
})

/**
 * サーバーサイドでget-taskasのAPIを実行し、
 * タスク一覧とユーザー情報を取得する
 * @method getTasks
 * */
var getTasks = function(idToken) {
	console.log('a1');
	//Ajax通信を行う
	$.ajax({
		url:"get-tasks",
		type:"POST",
		headers:{
			Authorization: 'Bearer '+idToken
		},
		dataType:"json"
	})
	.done((data) => {
		//成功した場合の処理
		console.log(data);
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
		$("#XMLHttpRequest").html("XMLHttpRequest : " + jqXHR.status);
		$("#textStatus").html("textStatus : " + textStatus);
		$("#errorThrown").html("errorThrown : " + errorThrown);
	})
	.always((data) => {
		//成功・失敗どちらでも行う処理
		console.log(data);
	});
};

/**
 * ログアウトボタン処理
 * ログアウトAPIを呼び出します
 * */
$('#LogoutButtton').off().on('click', function() {
	firebase.auth().signOut().then(()=>{
        console.log("ログアウトしました");
      })
      .catch( (error)=>{
        console.log(`ログアウト時にエラーが発生しました (${error})`);
      });
});