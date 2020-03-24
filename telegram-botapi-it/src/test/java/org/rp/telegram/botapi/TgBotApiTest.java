package org.rp.telegram.botapi;

import org.junit.Test;
import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.type.User;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 23.03.20
 * Time: 16:37
 */
public class TgBotApiTest {

    @Test
    public void getMeTest() throws BotApiException {
        TgBotApi tgBotApi = new TgBotApi();
        User user = tgBotApi.getMe("1073585381:AAHJ8XG593OkCwwdGTPPKR2Xt04wz0434q4");
        System.out.printf("user: " + user);
    }

}
