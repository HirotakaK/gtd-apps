package com.notstop.nsgtd.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * 下記を参考に試してみたもののうまくいかず..いったんストップ
 * 「Spring Bootでapplication.properties(yml)に独自の設定値を定義する - Qiita」https://qiita.com/NagaokaKenichi/items/4579849157cbe793c3d0
 * 「Spring Bootで定義ファイル(yaml)を参照する ｜ DevelopersIO」https://dev.classmethod.jp/etc/spring-boot-config-yaml/
 * */

@Component
@ConfigurationProperties(prefix = "values")
public class Settings {
    private String testa;
//    private Map<String, String> mapA;

    public void setTesta(String testa){
        this.testa = testa;
    }

    public String getTesta(){
        return testa;
    }

//    public void setMapA(Map<String, String> mapA){
//        this.mapA = mapA;
//    }
//
//    public Map<String, String> getMapA(){
//        return mapA;
//    }
}