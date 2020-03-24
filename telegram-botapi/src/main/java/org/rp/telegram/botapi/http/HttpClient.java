package org.rp.telegram.botapi.http;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rparshin
 * Date: 20.03.20
 * Time: 20:36
 */

// TODO: Add javadoc

public interface HttpClient {

    String queryStringGetRequest(String url) throws IOException;

}
