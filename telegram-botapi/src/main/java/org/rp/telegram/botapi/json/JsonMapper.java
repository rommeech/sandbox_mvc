package org.rp.telegram.botapi.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 21.03.20
 * Time: 20:32
 */

// TODO: Add javadoc
// TODO: we do not need to inject JsonMapper to API client!

public interface JsonMapper {

    String marshal(Object object) throws IOException;

    Object unmarshal(String json, TypeReference typeReference) throws IOException;

}
