package com.notstop.nsgtd.services;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.utils.SystemProperty;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

/**
 * 共通処理をまとめたファイルです
 * */

@Service
public class CommonService{

	@Autowired
	private Settings settings;

	/**
	 * AppEngine環境か区別する
	 * @return {boolean} (true AppEngine環境,false 非AppEngine環境)
	 * */
	public boolean isAppEngine() {
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
 		   // AppEngine
			return true;
 		 } else {
 		  // Local
 			return false;
 		}
	}

	/**
	 * リクエストヘッダよりトークンを取得し、ユーザーIDを取得する
	 * @method getUserIdFromToken
	 * */
	public String getUserIdFromToken(HttpServletRequest request) {
    	try {
    		// ヘッダよりuidを取得する
    		FileInputStream serviceAccount;
    		serviceAccount = new FileInputStream(settings.getFirebaseFilePath());
    		FirebaseOptions options = new FirebaseOptions.Builder()
    				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
    				.setDatabaseUrl("https://mygcpproject-146511.firebaseio.com")
    				.setProjectId("mygcpproject-146511")
    				.build();
    		if (FirebaseApp.getApps().isEmpty()) {
    			FirebaseApp.initializeApp(options);
    		}
    		return FirebaseAuth.getInstance().verifyIdToken(getToken(request)).getUid();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return null;
	}

	/**
	 * リクエストヘッダのAuthorizationよりトークンを返します。
	 * @param request リクエストヘッダ
	 * @return {String} トークン
	 * */
	public String getToken(HttpServletRequest request) {
    	String token = request.getHeader("Authorization");
    	if (token == null || !token.startsWith("Bearer ")) {
    		return null;
    	}
    	return token.substring("Bearer ".length());
    }
}
