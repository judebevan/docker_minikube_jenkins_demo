package com.loits.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/hello-world/welcome")
    public String Hellow() {
        return "Welcome to LOIT";
    }
}
