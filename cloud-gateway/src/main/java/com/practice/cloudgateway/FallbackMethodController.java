package com.practice.cloudgateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallback() {
        return "User service is taking longer than expected, please try again later";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallback() {
        return "Department service is taking longer than expected, please try again later";
    }
}
