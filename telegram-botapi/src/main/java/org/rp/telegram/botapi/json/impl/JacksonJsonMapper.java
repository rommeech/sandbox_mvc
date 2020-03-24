package org.rp.telegram.botapi.json.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rp.telegram.botapi.json.JsonMapper;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 21.03.20
 * Time: 20:40
 */

public class JacksonJsonMapper implements JsonMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String marshal(Object object) throws IOException {
        return mapper.writeValueAsString(object);
    }

    @Override
    public Object unmarshal(String json, TypeReference typeReference) throws IOException {
        return mapper.readValue(json, typeReference);
    }
}
