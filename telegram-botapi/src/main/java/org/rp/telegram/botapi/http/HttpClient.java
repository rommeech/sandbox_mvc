package org.rp.telegram.botapi.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:36
 */

// TODO: Add javadoc
// TODO: we do not need to inject JsonMapper to API client, cause we use Jackson annotation over all!

public interface HttpClient {

    String queryStringRequest(String url) throws IOException;

    String applicationXFormRequest(String url, Object object) throws IOException;

    String applicationJsonRequest(String url, String jsonString) throws IOException;

    String multipartFormDataRequest(String url, Map<String, Object> formData, String fileParameterName, File file) throws IOException;
}
