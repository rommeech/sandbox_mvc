package org.rp.sandboxmvc.service;

import org.rp.telegram.botapi.entity.User;
import org.rp.telegram.botapi.http.HttpException;
import org.rp.telegram.botapi.request.GetMeRequest;
import org.rp.telegram.botapi.response.UserResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "telegramApiService")
public class TelegramApiService {

    public User sendGetMeRequest(String token) throws ServiceException {

        GetMeRequest request = new GetMeRequest();
        UserResponse response;
        try {
            response = request.doRequest(token);
        } catch (HttpException | IOException e) {
            throw new ServiceException("GetMe request exception", e);
        }

        return response.getResult();
    }

}
