package com.example.prescriptionApp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/api/public/health")
    public String healthCheck() {
        return "OK (public)";
    }

    @GetMapping("/api/v1/health")
    public String privateHealth(){
        return "ok (secured)";
    }

}
