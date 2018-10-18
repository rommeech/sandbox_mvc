package org.rp.testapp;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpEngine {

    private static final String CHARSET = "UTF-8";

    public HttpEngine() {
    }

    public static void doJsonRequest(String targetUrl, String jsonData) throws IOException {
        URL url = new URL(targetUrl);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept-Charset", CHARSET);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + CHARSET);
        connection.setRequestProperty("Content-Length", Integer.toString(jsonData.getBytes().length));

        try(OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(jsonData.getBytes());
        }

        InputStream response = connection.getInputStream();

        /*try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
        }*/

        // Get body
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response))) {
            for (String line; (line = reader.readLine()) != null;) {
                stringBuilder.append(line);
            }
        }

        System.out.println("[RESPONSE]");
        System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());
        for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
        System.out.println();
        System.out.println(stringBuilder.toString());

    }

}
