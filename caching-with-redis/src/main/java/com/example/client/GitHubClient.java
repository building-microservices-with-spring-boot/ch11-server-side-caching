package com.example.client;

import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubClient {

    static Logger logger = LoggerFactory.getLogger(GitHubClient.class);

    RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "githubUser", key = "#username")
    public User getUser(@PathVariable String username) {
        logger.info("Requesting github profile for user: {}", username);
        return restTemplate.getForObject("https://api.github.com/users/{username}",
                User.class, username);
    }

}
