package com.example.lasttest.service;

import com.example.lasttest.mapper.PostMapper;
import com.example.lasttest.model.Comment;
import com.example.lasttest.model.Post;
import com.example.lasttest.model.PostImg;
import com.example.lasttest.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Slf4j
public class PostService {
    private final PostMapper postMapper;

    public void createPost(Post post){
        postMapper.createPost(post);
    }

    public List<Post> allPost(){
        return postMapper.allPost();
    }

    public Post getPostById(int postId){
        return postMapper.getPostById(postId);
    }

    public int getPostLike(int postId){
        return postMapper.getPostLike(postId);
    }

    public List<Comment> getComment(int postId){
        return postMapper.getComment(postId);
    }

    public int getCommentLike(int commentId){
        return postMapper.getCommentLike(commentId);
    }

    public List<PostImg> getPostImg(int postId){
        return postMapper.getPostImg(postId);
    }

    public Topic getTopic(int topicId){
        return postMapper.getTopic(topicId);
    }
}
