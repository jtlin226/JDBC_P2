package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name="content_body")
    private String content;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne(targetEntity = Review.class)
    @JoinColumn(name="review_id")
    private Review reviewId;

    public Comment(User userId, Review reviewId){
        content = "";
        this.userId = userId;
        this.reviewId = reviewId;
    }
}
