package com.example.me2u.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public void addPosting(@RequestBody Post post) {
        postService.addPost(post);
    }

    @GetMapping("/search")
    public Iterable<Post> showPostings() {
        return postService.getAllPostings();
    }

    @GetMapping("/search/{topic}")
    public Iterable<Post> showPostingsByTopic(@PathVariable String topic) {
        return postService.getAllPostingsByTopic(topic);
    }

}
