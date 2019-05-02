package com.notstop.nsgtd.services;

import org.springframework.stereotype.Service;

import com.google.appengine.api.utils.SystemProperty;

@Service
public class CommonServiceImpl implements CommonServiceIf {

	/**
	 * AppEngine環境か区別
	 * true AppEngine環境
	 * false 非AppEngine環境
	 * */
	public boolean isAppEngine() {
		System.out.println("e0");
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
 		   // AppEngine
			System.out.println("e1");
			return true;
 		 } else {
 		  // Local
 			System.out.println("e2");
 			return false;
 		}
	}
}
