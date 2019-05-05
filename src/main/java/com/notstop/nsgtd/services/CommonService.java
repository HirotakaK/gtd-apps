package com.notstop.nsgtd.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.appengine.api.utils.SystemProperty;

@Service
public class CommonService{

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
