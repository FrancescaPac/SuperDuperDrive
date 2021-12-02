package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    private CredentialsService credentialService;
    private UserService userService;

    public HomeController(CredentialsService credentialService, UserService userService) {
        this.credentialService = credentialService;
        this.userService = userService;
    }


    @GetMapping()
    public String homePageView(Authentication auth, Model model){
        User user = userService.getUser(auth.getPrincipal().toString());
        Integer userId = user.getUserId();
        model.addAttribute("credentials", this.credentialService.getAllCredentials(userId));
        model.addAttribute("newCredential", new Credentials());

        return "home";
    }
    //    @GetMapping
//    public String getHomePage(Model model) {
//        return "home";
//    }

    @PostMapping
    public String logOut(Model model) {
        return "login";
    }



}