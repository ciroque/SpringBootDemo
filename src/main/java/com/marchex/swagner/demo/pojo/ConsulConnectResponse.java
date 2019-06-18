package com.marchex.swagner.demo.pojo;

import java.util.List;
import java.util.Map;

public class ConsulConnectResponse {
    private String status;

    public ConsulConnectResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
