package org.rp.sandboxmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.entity.User;
import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.request.RequestException;
import org.rp.telegram.botapi.response.UserResponse;
import org.springframework.stereotype.Service;

@Service(value = "telegramApiService")
public class TelegramApiService {

    public static final Logger logger = LogManager.getLogger(TelegramApiService.class);

    public User sendGetMeRequest(String token) throws ServiceException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response;
        try {
            response = request.doRequest(token);
        } catch (RequestException e) {
            logger.error("sendGetMeRequest", e);
            throw new ServiceException("GetMeRequest error", e);
        }

        return response.getResult();
    }

}
