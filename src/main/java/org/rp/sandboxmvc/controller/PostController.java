package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.model.feed.Post;
import org.rp.sandboxmvc.service.feed.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LogManager.getLogger(PostController.class);

    @RequestMapping("/")
    public String postList(Model model) {

        Map<String, String> requestParams = this.getRequestParams();

        List<Post> postList = postService.list(requestParams);

        model.addAttribute("postList", postList);

        return "feed/post_list";
    }

    @RequestMapping(value = "/view/{id}/", method = RequestMethod.GET)
    public String postView(@PathVariable Long id, Model model) {
        Post post = postService.getById(id);
        if (post == null) {
            throw new NotFoundException();
        }
        model.addAttribute("post", post);
        return "feed/post_view";
    }

    private Map<String, String> getRequestParams() {
        Map<String, String> requestParams = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            requestParams.put(parameterName, request.getParameter(parameterName));
        }
        logger.debug("requestParams: " + requestParams);
        return requestParams;
    }

}
