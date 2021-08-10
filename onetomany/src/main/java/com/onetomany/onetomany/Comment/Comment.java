package com.onetomany.onetomany.Comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onetomany.onetomany.Post.Post;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne
    @JsonBackReference
    private Post post;

    public Comment() {
    }

    public Comment(String commentText) {
        this.commentText = commentText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
