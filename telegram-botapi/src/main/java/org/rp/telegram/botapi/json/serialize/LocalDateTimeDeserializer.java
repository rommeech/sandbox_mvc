package org.rp.telegram.botapi.json.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 15.04.20
 * Time: 16:29
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(Long.valueOf(jsonParser.getText())),
                TimeZone.getDefault().toZoneId()
        );
    }
}
