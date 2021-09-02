package com.revature.ghiblihub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController() {

    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/postreview")
    public String postReviewPage() {
        return "postreview";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login/newuser")
    public String createUserPage() {
        return "newuser";
    }
}
