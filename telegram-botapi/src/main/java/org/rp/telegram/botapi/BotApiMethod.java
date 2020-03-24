package org.rp.telegram.botapi;

import org.rp.telegram.botapi.exception.BotApiException;
import org.rp.telegram.botapi.exception.HttpException;
import org.rp.telegram.botapi.exception.JsonException;
import org.rp.telegram.botapi.util.ResponseModel;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 18.03.20
 * Time: 17:53
 */

// TODO: Add javadoc

public interface BotApiMethod extends Serializable {

    ResponseModel doRequest() throws BotApiException;

}
