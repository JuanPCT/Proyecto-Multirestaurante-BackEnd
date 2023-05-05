package com.multiristorante.app.backend.security;

import com.multiristorante.app.backend.SpringApplicationContext;

public class SecurityConstans {

    public static final long EXPIRATION_DATE = 86400;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/usuarios";
    
    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties)SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
    
}
