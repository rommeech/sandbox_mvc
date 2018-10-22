package org.rp.testapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.rp.telegram.botapi.entity.User;
import org.rp.telegram.botapi.response.AbstractApiResponse;

import java.io.IOException;
import java.util.Map;

public class JacksonTestApp {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        String json = "{\"ok\":true,\"result\":{\"id\":468561122,\"is_bot\":true,\"first_name\":\"WerterBot\",\"username\":\"WerterRobot\"}}";
        ObjectMapper mapper = new ObjectMapper();

        // Test json to map
        Map<String, Object> mapFromJson = mapper.readValue(json, Map.class);
        System.out.println(mapFromJson);

        // Test json to AbstractApiResponse
        ApiHttpResponseUser<AbstractApiResponse<User>> apiHttpResponseUser = new ApiHttpResponseUser<>();
        apiHttpResponseUser.parseJson(json, AbstractApiResponse.class);

    }

    private static class ApiHttpResponseUser<T> {

        ObjectMapper mapper = new ObjectMapper();


        public void parseJson(String json, Class<AbstractApiResponse> clazz) throws IOException, IllegalAccessException, InstantiationException {

            AbstractApiResponse response = mapper.readValue(json, clazz);
            System.out.println(response);
        }

    }

}




