package org.rp.telegram.botapi;

import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.type.User;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 18.03.20
 * Time: 17:44
 */

// TODO: Add javadoc

public interface BotApiClient {

    String getApiVersion();

    User getMe(String token) throws BotApiException;

}
