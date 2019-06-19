package com.marchex.swagner.demo.controllers;

import com.marchex.swagner.demo.pojo.ConsulConnectResponse;
import com.marchex.swagner.demo.pojo.HealthResponse;
import com.marchex.swagner.demo.pojo.Libraries;
import com.orbitz.consul.Consul;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("Healthy");
    }

    @RequestMapping("/health/consul-connection")
    public ConsulConnectResponse testConsulConnection() {
        ConsulConnectResponse response;

        try {
        Consul client = Consul.builder().withUrl("http://localhost:8500").build();
//            Consul client = Consul.builder().withUrl("http://consul.us-east-1.marchex.net:8500/").build();
            response = new ConsulConnectResponse("available");
        } catch(Exception ex) {
            response = new ConsulConnectResponse(String.format("not-available: %s", ex.getMessage()));
        }

        return response;
    }

    @RequestMapping("/health/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping("/health/libraries")
    public Libraries libraries() {
        return Libraries.GetLibraries();
    }
}
