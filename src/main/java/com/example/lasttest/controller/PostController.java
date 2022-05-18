package com.example.lasttest.controller;

import com.example.lasttest.model.Comment;
import com.example.lasttest.model.Post;
import com.example.lasttest.model.PostImg;
import com.example.lasttest.model.Topic;
import com.example.lasttest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post){
        postService.createPost(post);
        return post;
    }

    @GetMapping("/post")
    public List<Post> allPost(){
        return postService.allPost();
    }

    @GetMapping("/post/{postId}")
    public Post getPostById(@PathVariable("postId") int postId){
        return postService.getPostById(postId);
    }

    @GetMapping("/post/user/{userId}")
    public List<Post> getPostByUserId(@PathVariable("userId") int userId){
        return postService.getPostByUserId(userId);
    }

    @GetMapping("/post/like/{postId}")
    public int getPostLike(@PathVariable("postId") int postId){
        return postService.getPostLike(postId);
    }

    @GetMapping("/post/comment/{postId}")
    public List<Comment> getComment(@PathVariable("postId") int postId){
        return postService.getComment(postId);
    }

    @GetMapping("/post/comment/like/{commentId}")
    public int getCommentLike(@PathVariable("commentId") int commentId){
        return postService.getCommentLike(commentId);
    }

    @GetMapping("/post/img/{postId}")
    public List<PostImg> getPostImg(@PathVariable("postId") int postId){
        return postService.getPostImg(postId);
    }

    @GetMapping("/post/topic/{topicId}")
    public Topic getTopic(@PathVariable("topicId") int topicId){
        return postService.getTopic(topicId);
    }
}
