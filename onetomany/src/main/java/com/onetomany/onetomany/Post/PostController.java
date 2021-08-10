package com.onetomany.onetomany.Post;

import com.onetomany.onetomany.Comment.Comment;
import com.onetomany.onetomany.Comment.CommentRepository;
import com.onetomany.onetomany.PostDetail.PostDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/addPost")
    public void addPost() {
//        Post post = new Post("new Post");

//        Post post = postRepository.findById(1L).get();
        Post post = new Post(1L);
        Comment comment = new Comment("my fifth reviw");
        comment.setPost(post);
        post.getCommentList().clear();
        post.setCommentList(Arrays.asList(comment));
//        post.getCommentList().add(new Comment("My fifth review"));
//        post.getCommentList().add(new Comment("My sixth review"));

        postRepository.save(post);

    }
}
