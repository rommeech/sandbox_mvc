package org.rp.telegram.botapi.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.telegram.botapi.type.User;
import org.rp.telegram.botapi.util.ResponseModel;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 19.03.20
 * Time: 15:49
 */
public class ResponseModelParserTest {

    private ObjectMapper mapper;
    private ClassLoader classLoader;
    private final static Logger LOGGER = LogManager.getLogger(ResponseModelParserTest.class);

    @Before
    public void setUp() {
        mapper = new ObjectMapper();

    }

    @Test
    public void getMeOkTest() throws IOException {
        classLoader = getClass().getClassLoader();

        final String json = "{\n" +
                "  \"ok\": true,\n" +
                "  \"result\": {\n" +
                "    \"id\": 123456789,\n" +
                "    \"is_bot\": true,\n" +
                "    \"first_name\": \"FooBarBot\",\n" +
                "    \"username\": \"Foo Bar The Bot\",\n" +
                "    \"can_join_groups\": true,\n" +
                "    \"can_read_all_group_messages\": false,\n" +
                "    \"supports_inline_queries\": false\n" +
                "  }\n" +
                "}";

        ResponseModel<User> responseModel = mapper.readValue(json, new TypeReference<ResponseModel<User>>(){});
        LOGGER.info(responseModel);

        assertTrue("Field 'ok'", responseModel.getOk());
        assertNull("Field 'description'", responseModel.getDescription());
        assertNull("Field 'error_code'", responseModel.getErrorCode());

        assertNull("Field 'parameters'", responseModel.getParameters());

        assertTrue("Field 'result/id'", 123456789L == responseModel.getResult().getId());
        assertTrue("Field 'result/is_bot'", responseModel.getResult().getBot());
        assertEquals("Field 'result/first_name'", "FooBarBot", responseModel.getResult().getFirstName());
        assertNull("Field 'result/last_name'", responseModel.getResult().getLastName());
        assertEquals("Field 'result/username'", "Foo Bar The Bot", responseModel.getResult().getUsername());
        assertNull("Field 'result/language_code'", responseModel.getResult().getLanguageCode());
        assertTrue("Field 'result/can_join_groups'", responseModel.getResult().getCanJoinGroups());
        assertFalse("Field 'result/can_read_all_group_messages'", responseModel.getResult().getCanReadAllGroupMessages());
        assertFalse("Field 'result/supports_inline_queries'", responseModel.getResult().getSupportsInlineQueries());
    }

    @Test
    public void getMeFullOkTest() throws IOException {
        classLoader = getClass().getClassLoader();

        final String json = "{\n" +
                "  \"ok\": true,\n" +
                "  \"description\": \"Foo Bar Baz Description\",\n" +
                "  \"error_code\": 1,\n" +
                "  \"parameters\": {\n" +
                "    \"migrate_to_chat_id\": 111,\n" +
                "    \"retry_after\": 222\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"id\": 123456,\n" +
                "    \"is_bot\": true,\n" +
                "    \"first_name\": \"First Name\",\n" +
                "    \"last_name\": \"Last Name\",\n" +
                "    \"username\": \"UserNameBot\",\n" +
                "    \"language_code\": \"EN\",\n" +
                "    \"can_join_groups\": true,\n" +
                "    \"can_read_all_group_messages\": false,\n" +
                "    \"supports_inline_queries\": false\n" +
                "  }\n" +
                "}";

        ResponseModel<User> responseModel = mapper.readValue(json, new TypeReference<ResponseModel<User>>(){});
        LOGGER.info(responseModel);

        assertTrue("Field 'ok'", responseModel.getOk());
        assertEquals("Field 'description'", "Foo Bar Baz Description", responseModel.getDescription());
        assertTrue("Field 'error_code'", 1 == responseModel.getErrorCode());

        assertTrue("Field 'parameters/migrate_to_chat_id'", 111 == responseModel.getParameters().getMigrateToCharId());
        assertTrue("Field 'parameters/retry_after'", 222 == responseModel.getParameters().getRetryAfter());

        assertTrue("Field 'result/id'", 123456 == responseModel.getResult().getId());
        assertTrue("Field 'result/is_bot'", responseModel.getResult().getBot());
        assertEquals("Field 'result/first_name'", "First Name", responseModel.getResult().getFirstName());
        assertEquals("Field 'result/last_name'", "Last Name", responseModel.getResult().getLastName());
        assertEquals("Field 'result/username'", "UserNameBot", responseModel.getResult().getUsername());
        assertEquals("Field 'result/language_code'", "EN", responseModel.getResult().getLanguageCode());
        assertTrue("Field 'result/can_join_groups'", responseModel.getResult().getCanJoinGroups());
        assertFalse("Field 'result/can_read_all_group_messages'", responseModel.getResult().getCanReadAllGroupMessages());
        assertFalse("Field 'result/supports_inline_queries'", responseModel.getResult().getSupportsInlineQueries());
    }

    @Test
    public void getMeNokTest() throws IOException {
        classLoader = getClass().getClassLoader();

        final String json = "{\n" +
                "  \"ok\": false,\n" +
                "  \"error_code\": 401,\n" +
                "  \"description\": \"Unauthorized\"\n" +
                "}";

        ResponseModel<User> responseModel = mapper.readValue(json, new TypeReference<ResponseModel<User>>(){});
        LOGGER.info(responseModel);

        assertFalse("Field 'ok'", responseModel.getOk());
        assertEquals("Field 'description'", "Unauthorized", responseModel.getDescription());
        assertTrue("Field 'error_code'", 401 == responseModel.getErrorCode());

        assertNull("Field 'parameters'", responseModel.getParameters());

        assertNull("Field 'result'", responseModel.getResult());
    }


}