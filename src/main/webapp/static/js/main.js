firebase.auth().onAuthStateChanged( (user) => {
	let h1   = document.querySelector('h1');
	let info = document.querySelector('#info');

	if(user) {
//		h1.innerText   = 'Login Complete!';
//		info.innerHTML = `${user.displayName}さんがログインしました`;
		console.log(user);
		console.table(user);
	}
	else {
		// firebase未ログインの場合
		window.location.href = 'login.html';
	}
	firebase.auth().currentUser.getIdToken(/* forceRefresh */ true).then(function(idToken) {
		//Ajaxに渡すデータ
		var dt = {a:1, b:2};  //このサンプルでは関係ありません。

		//Ajax通信を行う
		$.ajax({
			url:"test2",
			type:"GET",
			headers:{
				Authorization: 'Bearer '+idToken
			},
			dataType:"json",
			data:dt
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
	}).catch(function(error) {
		// Handle error
	});
});

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