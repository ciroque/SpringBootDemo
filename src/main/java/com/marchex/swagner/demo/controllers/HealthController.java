package com.marchex.swagner.demo.controllers;

import com.marchex.swagner.demo.pojo.HealthResponse;
import com.marchex.swagner.demo.pojo.Libraries;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("Healthy");
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping("/libraries")
    public Libraries libraries() {
        return Libraries.GetLibraries();
    }
}
