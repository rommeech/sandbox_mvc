package org.rp.testapp;

import org.rp.telegram.botapi.entity.FormatOption;
import org.rp.telegram.botapi.request.RequestException;
import org.rp.telegram.botapi.request.SendMessageRequest;
import org.rp.telegram.botapi.response.MessageResponse;

public class TestSendMessageApp {

    public static void main(String[] args) throws RequestException {

        String chatId = args[0];
        String token = args[1];

        SendMessageRequest request = new SendMessageRequest.Builder()
                .chatId(chatId)
                .parseMode(FormatOption.HTML)
                .text("Test!")
                .build();

        MessageResponse messageResponse = request.doRequest(token);

        System.out.println(messageResponse);

    }

}
