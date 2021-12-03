package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialsController {

    private final UserService userService;
    private final CredentialsService credentialsService;

    public CredentialsController(UserService userService, CredentialsService credentialsService) {
        this.userService = userService;
        this.credentialsService = credentialsService;
    }

    @PostMapping("/add-credential")
    public String addNewCredentialOrUpdate(Credentials credentials, Authentication authentication, Model model){
       User user = userService.getUser(authentication.getPrincipal().toString());
       credentials.setUserId(user.getUserId());
       
       credentialsService.addCredentials(credentials);
       model.addAttribute("successMessage", "The credential added successfully!");
       return "result";
        }

}
