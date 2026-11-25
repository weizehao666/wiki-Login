/*
 * Name: Wei Zehao
 * Student ID: S1580667
 */
package com.wiki.wikilogin.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String validUsername = "wei";
    private final String validPassword = "123";

    public boolean authenticate(String inputUsername, String inputPassword){
        return validUsername.equals(inputUsername) && validPassword.equals(inputPassword);
    }
}

