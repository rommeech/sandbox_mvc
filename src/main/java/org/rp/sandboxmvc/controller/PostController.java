package org.rp.sandboxmvc.controller;

import org.rp.sandboxmvc.service.feed.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String postsList(Model model) {
        model.addAttribute("postsList", postService.getPosts());
        return "feed/posts_list";
    }

}
