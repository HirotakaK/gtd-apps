package com.notstop.nsgtd;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notstop.nsgtd.services.BusinessService;
import com.notstop.nsgtd.services.CommonService;

@RestController
public class MainController {

	@Autowired
	BusinessService businessService;

	@Autowired
	CommonService commonService;

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
    	// リクエストヘッダよりuidを取得する
    	String uid = commonService.getUserIdFromToken(request);
    	// uidよりタスクを取得する
    	businessService.getUserTasks(uid);
    	return uid;
    }

}