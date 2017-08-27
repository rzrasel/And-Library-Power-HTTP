package com.rz.powerhttp;

/**
 * Created by Rz Rasel on 2017-08-27.
 */

public enum HTTPMethod {
    GET("GET"), POST("POST"), DELETE("DELETE");
    private final String methodName;

    HTTPMethod(String argMethodName) {
        this.methodName = argMethodName;
    }

    public String getMethodName() {
        return this.methodName;
    }
}