package com.notstop.nsgtd;


import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.notstop.nsgtd.services.CommonService;

@RestController
public class MainController {

    @RequestMapping(value="/test3")
    private String hello() {
    	System.out.println("\r\n\\r\\n\\r\\n hello, world \\r\\n\\\\r\\\\n\\\\r\\\\n");
    	System.out.println("\r\n\\r\\n\\r\\n hello, world \\r\\n\\\\r\\\\n\\\\r\\\\n");
    	System.out.println("\r\n\\r\\n\\r\\n hello, world \\r\\n\\\\r\\\\n\\\\r\\\\n");
    	System.out.println("\r\n\\r\\n\\r\\n hello, world \\r\\n\\\\r\\\\n\\\\r\\\\n");
        return "test03!!";
    }

    /**
     * uidよりタスク一覧を取得します
     * 該当のuid項目が存在しない場合は新規ユーザーとして登録します
     * */
    @RequestMapping(value="/get-tasks")
    private String getTasks(HttpServletRequest request) {
    	String uid = "";
    	CommonService commonService = new CommonService();
    	try {
    		FileInputStream serviceAccount;
    		if(commonService.isAppEngine()) {
    			serviceAccount = new FileInputStream("./WEB-INF/server-resources/mygcpproject-146511-firebase-adminsdk-bjwq1-cdf5f808b8.json");
    		}else {
    			serviceAccount = new FileInputStream("./src/main/webapp/WEB-INF/server-resources/mygcpproject-146511-firebase-adminsdk-bjwq1-cdf5f808b8.json");
    		}
    		FirebaseOptions options = new FirebaseOptions.Builder()
    				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
    				.setDatabaseUrl("https://mygcpproject-146511.firebaseio.com")
    				.setProjectId("mygcpproject-146511")
    				.build();
    		if (FirebaseApp.getApps().isEmpty()) {
    			FirebaseApp.initializeApp(options);
    		}
    		uid = FirebaseAuth.getInstance().verifyIdToken(commonService.getToken(request)).getUid();
    		System.out.println("uid:" + uid);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return uid;
    }

    // MyBatis
//    private final TestMapper testMapper;

//    public MainController(TestMapper testMapper) {
//        this.testMapper = testMapper; // Mapperをインジェクションする
//    }

    @Transactional
    public void run2() throws Exception {
    	System.out.println("START");
//        Todo newTodo = new Todo();
//        newTodo.setTitle("飲み会");
//        newTodo.setDetails("銀座 19:00");
//
//    	testMapper.insert(); // 新しいTodoをインサートする
//
//        Todo loadedTodo = todoMapper.select(newTodo.getId()); // インサートしたTodoを取得して標準出力する
//        System.out.println("ID       : " + loadedTodo.getId());
//        System.out.println("TITLE    : " + loadedTodo.getTitle());
//        System.out.println("DETAILS  : " + loadedTodo.getDetails());
//        System.out.println("FINISHED : " + loadedTodo.isFinished());
    	System.out.println("FINISHED");
    }
}