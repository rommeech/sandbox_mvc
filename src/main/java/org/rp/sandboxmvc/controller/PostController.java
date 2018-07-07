package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.dao.SearchCriteria;
import org.rp.sandboxmvc.model.feed.Post;
import org.rp.sandboxmvc.service.feed.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private HttpServletRequest request;

    private static final Logger logger = LogManager.getLogger(PostController.class);

    @RequestMapping(value = "/view/{id}/", method = RequestMethod.GET)
    public String postView(@PathVariable Long id, Model model) {
        Post post = postService.getById(id);
        if (post == null) {
            throw new NotFoundException();
        }
        model.addAttribute("post", post);
        return "feed/post_view";
    }

    // TODO: refactoring, use Command object
    @RequestMapping("/")
    public String postList(Model model, SearchCriteria searchCriteria) {
        logger.info("Search criteria: " + searchCriteria);
        List<Post> postList = postService.list(searchCriteria);
        model.addAttribute("postList", postList);
        return "feed/post_list";
    }

}
