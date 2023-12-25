package com.spring.aop.springaop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.spring.aop.springaop.services.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap(
            "greeting", greetingService.sayHello("Pepe", "Hello")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap(
            "greeting", greetingService.sayHello("Pepe", "Hello")));
    }

}
