package com.app.vitalsign.config.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "userClient", url = "http://localhost:8084")
public interface UserClient {

    @GetMapping("/api/users")
    ResponseEntity<List<User>> getAllUser(@RequestHeader("Authorization") String token);

    @PostMapping("/auth/login")
    String login(@RequestParam("username") String username, @RequestParam("password") String password);
}
