package com.onetomany.onetomany.Comment;

import com.onetomany.onetomany.Post.PostDTO;

public class CommentDTO {

    private Long id;
    private String commentText;
    private PostDTO postDTO;

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

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }
}
