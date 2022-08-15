package com.lihanyu.Utiliy;

import java.util.Base64;

public class TokenCreate {

    public static String tokenCreate(String username) {
        Base64.Encoder encoder = Base64.getEncoder();
        String token = encoder.encodeToString((username + System.currentTimeMillis()).getBytes());
        return token;
    }

}
