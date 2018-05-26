package org.rp.sandboxmvc.ui.feed;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.ui.UITools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FeedServlet", urlPatterns = "/feeds/*")
public class FeedServlet extends HttpServlet {

    public static Logger logger = LogManager.getLogger(FeedServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> pathSegments = (List<String>) request.getAttribute("pathSegments");

        if (pathSegments == null || pathSegments.size() == 0) {
            renderFeedsList(request, response);
        }
        else {
            UITools.renderError404(request, response);
        }

    }

    private void renderFeedsList(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
