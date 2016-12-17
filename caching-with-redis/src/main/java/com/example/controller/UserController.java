package com.example.controller;

import com.example.client.GitHubClient;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {


    GitHubClient gitHubClient;

    @Autowired
    public UserController(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @RequestMapping(value = "/github/{username}")
    User getUser(@PathVariable String username) {
        return gitHubClient.getUser(username);
    }
}
