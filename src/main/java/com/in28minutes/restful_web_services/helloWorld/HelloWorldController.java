package com.in28minutes.restful_web_services.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello Bean");
    }
}