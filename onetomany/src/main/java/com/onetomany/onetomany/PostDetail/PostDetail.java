package com.onetomany.onetomany.PostDetail;

import com.onetomany.onetomany.Post.Post;

import javax.persistence.*;

@Entity
@Table(name = "post_detail")
public class PostDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "post_param_one")
    private String postParamOne;

    @Column(name = "post_param_two")
    private String postParamTwo;

    @OneToOne
    @JoinColumn(unique = true)
    private Post post;

    public PostDetail(String postParamOne, String postParamTwo) {
        this.postParamOne = postParamOne;
        this.postParamTwo = postParamTwo;
    }

    public PostDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostParamOne() {
        return postParamOne;
    }

    public void setPostParamOne(String postParamOne) {
        this.postParamOne = postParamOne;
    }

    public String getPostParamTwo() {
        return postParamTwo;
    }

    public void setPostParamTwo(String postParamTwo) {
        this.postParamTwo = postParamTwo;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
