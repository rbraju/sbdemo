package com.springboot.sbdemo.controller;

import com.springboot.sbdemo.dto.DefaultResponse;
import com.springboot.sbdemo.dto.Greeting;
import com.springboot.sbdemo.dto.Login;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LoginController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/login")
    public DefaultResponse login(@RequestParam String username, String password) {
        boolean isValidLogin = isValidLogin(username, password);
        String message = isValidLogin ? "Login succeeded.." : "Invalid login";
        return new DefaultResponse(isValidLogin, message);
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public DefaultResponse login(@RequestBody Login login) {
        boolean isValidLogin = isValidLogin(login.getUsername(), login.getPassword());
        String message = isValidLogin ? "Login succeeded.." : "Invalid login";
        return new DefaultResponse(isValidLogin, message);
    }

    private boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}
