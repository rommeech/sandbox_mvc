package org.rp.telegram.botapi.util;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 23.03.20
 * Time: 13:02
 */
public enum MethodName {

    GET_ME("getMe");

    private final String apiMethodName;

    MethodName(String apiMethodName) {
        this.apiMethodName = apiMethodName;
    }

    public String apiMethodName() {
        return apiMethodName;
    }

    @Override
    public String toString() {
        return "MethodName{" +
                "apiMethodName='" + apiMethodName + '\'' +
                '}';
    }
}
