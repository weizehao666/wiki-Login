/*
 * Name: Wei Zehao
 * Student ID: S1580667
 */
package com.wiki.wikilogin.controller;

import com.wiki.wikilogin.model.LoginForm;
import com.wiki.wikilogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(LoginForm loginForm, Model model){
        boolean isSuccess = loginService.authenticate(loginForm.getUsername(), loginForm.getPassword());

        if(isSuccess){
            model.addAttribute("userName", loginForm.getUsername());
            return "welcome";
        }else{
            model.addAttribute("errorMsg", "Username or Password is incorrect! Please try again.");
            return "login";
        }
    }
}
