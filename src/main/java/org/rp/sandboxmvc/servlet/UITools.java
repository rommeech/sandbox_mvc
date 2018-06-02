package org.rp.sandboxmvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UITools {

    public static void renderError404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        PrintWriter writer = response.getWriter();
        writer.println("<h1>404 Not Found</h1>");
    }

}
