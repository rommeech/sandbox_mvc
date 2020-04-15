package org.rp.telegram.botapi.json.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 26.03.20
 * Time: 12:33
 */
public class JacksonListDeserializer<T> extends JsonDeserializer<List<T>> {

    public JacksonListDeserializer() {
    }

    @Override
    public List<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        NestedItems<T> nestedItems = jsonParser.readValueAs(new TypeReference<NestedItems<T>>(){});
        return nestedItems.nestedItems;
    }

    private static class NestedItems<T>{
        public List<T> nestedItems;
    }
}

/*
https://stackoverflow.com/questions/19580856/jackson-list-deserialization-nested-lists
https://stackoverflow.com/questions/11747370/jackson-how-to-process-deserialize-nested-json
https://stackoverflow.com/questions/27895376/deserialize-nested-array-as-arraylist-with-jackson
 */
