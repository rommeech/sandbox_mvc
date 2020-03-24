package org.rp.testapp;

import org.rp.tg.botapi.type.FormatOption;
import org.rp.tg.botapi.request.RequestException;
import org.rp.tg.botapi.request.SendMessageRequest;
import org.rp.tg.botapi.response.MessageResponse;

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
