package org.rp.sandboxmvc.servlet.feed;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.feed.Feed;
import org.rp.sandboxmvc.service.feed.FeedService;
import org.rp.sandboxmvc.servlet.UITools;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "FeedServlet", urlPatterns = "/feeds/*")
public class FeedServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(FeedServlet.class);
    private FeedService feedService;

    public FeedServlet(FeedService feedService) {
        this.feedService = feedService;
    }

    public FeedServlet() {
        this.feedService = new FeedService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> pathSegments = (List<String>) request.getAttribute("pathSegments");

        if (pathSegments == null || pathSegments.size() == 0) {
            renderFeedsList(request, response);
        }
        else if (pathSegments.size() == 1 && StringUtils.isNumeric(pathSegments.get(0))) {
            renderFeedsForm(request, response, Long.parseLong(pathSegments.get(0)));
        }
        else {
            logger.error("Page not found: " + request.getRequestURL());
            UITools.renderError404(request, response);
        }

    }

    private void renderFeedsList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Feed> feedList = feedService.getAll();
        request.setAttribute("feedList", feedList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/feed/feed_list.jsp");
        dispatcher.forward(request, response);

    }

    private void renderFeedsForm(HttpServletRequest request, HttpServletResponse response, Long id) throws ServletException, IOException {

        Feed feed = feedService.getById(id);
        if (feed == null) {
            logger.error("FeedID not found: " + request.getRequestURL());
            UITools.renderError404(request, response);
            return;
        }
        request.setAttribute("feed", feed);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/feed/feed_form.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
