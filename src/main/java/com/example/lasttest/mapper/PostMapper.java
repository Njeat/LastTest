package com.example.lasttest.mapper;

import com.example.lasttest.model.Comment;
import com.example.lasttest.model.Post;
import com.example.lasttest.model.PostImg;
import com.example.lasttest.model.Topic;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Insert("INSERT INTO post (userId, postDetail, topicId) VALUES" +
            "(#{post.userId},#{post.postDetail},#{post.topicId})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    void createPost(@Param("post") Post post);

    @Select("SELECT * FROM post")
    @Results(id="PostMap", value = {
            @Result(property = "user", column = "userId", many = @Many(select = "com.example.lasttest.mapper.UserMapper.getUserById")),
            @Result(property = "postLike", column = "postId", many = @Many(select = "com.example.lasttest.mapper.PostMapper.getPostLike")),
            @Result(property = "comment", column = "postId", many = @Many(select = "com.example.lasttest.mapper.PostMapper.getComment")),
            @Result(property = "postImg", column = "postId", many = @Many(select = "com.example.lasttest.mapper.PostMapper.getPostImg")),
            @Result(property = "topic", column = "topicId", many = @Many(select = "com.example.lasttest.mapper.PostMapper.getTopic"))
    })
    List<Post> allPost();

    @Select("SELECT * FROM post WHERE postId = #{postId}")
    @ResultMap("PostMap")
    Post getPostById(@Param("postId") int postId);

    @Select("SELECT * FROM post WHERE userId = #{userId}")
    @ResultMap("PostMap")
    List<Post> getPostByUserId(@Param("userId") int userId);

    @Select("SELECT count(postLikeId) FROM postLike WHERE status='TRUE' GROUP BY postId HAVING postId=#{postId}")
    int getPostLike(@Param("postId") int postId);

    @Select("SELECT * FROM comment WHERE postId=#{postId}")
    @Results(id="CommentMap", value = {
            @Result(property = "commentLike", column = "commentId", many = @Many(select = "com.example.lasttest.mapper.PostMapper.getCommentLike"))
    })
    List<Comment> getComment(@Param("postId") int postId);

    @Select("SELECT count(commentLikeId) FROM commentLike WHERE status='TRUE' GROUP BY commentId HAVING commentId=#{commentId}")
    int getCommentLike(@Param("commentId") int commentId);

    @Select("SELECT * FROM postImg WHERE postId=#{postId}")
    List<PostImg> getPostImg(@Param("postId") int postId);

    @Select("SELECT * FROM topic WHERE topicId=#{topicId}")
    Topic getTopic(@Param("topicId") int topicId);
}
