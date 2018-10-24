package org.rp.telegram.botapi.helper;

public enum ApiMethod {

    GET_ME("getMe"),
    SEND_MESSAGE("sendMessage");

    private String methodName;

    ApiMethod(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }
}
