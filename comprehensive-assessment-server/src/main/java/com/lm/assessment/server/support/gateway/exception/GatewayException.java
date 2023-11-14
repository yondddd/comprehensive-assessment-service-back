package com.lm.assessment.server.support.gateway.exception;

public class GatewayException extends RuntimeException {
    private int code=500;

    public GatewayException(String message) {
        super(message);
    }

    public GatewayException(int code, String message) {
        super(message);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}