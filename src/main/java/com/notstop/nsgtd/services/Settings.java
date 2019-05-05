package com.notstop.nsgtd.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * application.propertiesとpom.xmlの情報を取得する
 * */

@Component
@ConfigurationProperties(prefix = "values")
public class Settings {

	private String firebaseFilePath;

    public void setFirebaseFilePath(String firebaseFilePath){
        this.firebaseFilePath = firebaseFilePath;
    }

    public String getFirebaseFilePath(){
        return firebaseFilePath;
    }

}