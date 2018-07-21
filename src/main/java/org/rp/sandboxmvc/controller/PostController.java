package org.rp.sandboxmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rp.sandboxmvc.helper.PostSearchCriteria;
import org.rp.sandboxmvc.model.feed.Post;
import org.rp.sandboxmvc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/posts")
public class PostController {

    private static final Logger logger = LogManager.getLogger(PostController.class);
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
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

    // TODO: refactoring, use Command object
    @RequestMapping("/")
    public String postList(Model model, PostSearchCriteria searchCriteria) {
        model.addAttribute("posts", postService.getPosts(searchCriteria));
        model.addAttribute("total", postService.countPosts(searchCriteria));
        model.addAttribute("searchCriteria", searchCriteria);
        return "feed/post_list";
    }

}
