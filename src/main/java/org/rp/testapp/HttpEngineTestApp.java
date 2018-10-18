package org.rp.testapp;

import java.io.IOException;

public class HttpEngineTestApp {

    public static void main(String[] args) {

        try {
            HttpEngine.doJsonRequest("https://api.telegram.org/bot468561122:AAHdWFuL5s0meYG9fcJOR6VkEiH1iu7cpU8/getMe", "{}");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
