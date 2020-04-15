package org.rp.telegram.botapi;

import org.junit.Test;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.requestmodel.SendMessageRequestModel;
import org.rp.telegram.botapi.type.Message;
import org.rp.telegram.botapi.util.ParseMode;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 10.04.20
 * Time: 21:02
 */
public class SendMessageTest {

    @Test
    public void sendMessageTest() throws BotApiException {
        TelegramBotApi tgBotApi = new TelegramBotApi();
        SendMessageRequestModel requestModel = new SendMessageRequestModel.Builder()
                .chatId("-1001146069923")
                .text("Test 111")
                .build();
        Message message = tgBotApi.sendMessage("1073585381:AAHJ8XG593OkCwwdGTPPKR2Xt04wz0434q4", requestModel);
        System.out.printf("message: " + message);
    }

}
