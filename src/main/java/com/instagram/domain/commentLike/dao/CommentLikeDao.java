package com.instagram.domain.commentLike.dao;

import com.instagram.domain.comment.domain.Comment;
import com.instagram.domain.commentLike.domain.CommentLike;
import com.instagram.domain.post.domain.Post;
import com.instagram.domain.postLike.domain.PostLike;
import com.instagram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CommentLikeDao extends JpaRepository<CommentLike, Long> {



    /* 21. commentLikeIdx 통해 CommentLike 엔티티 조회  */
    @Query(value="select cl from CommentLike cl where cl.idx = :commentLikeIdx and cl.status = 'ACTIVE'")
    CommentLike findByIdx(@Param("commentLikeIdx") Long commentLikeIdx);


    /* 20. user 객체와 comment 객체를 통해 commentLike 엔티티 조회  */
    @Query(value="select cl from CommentLike cl where cl.user = :user and cl.comment = :comment and cl.status = 'ACTIVE'")
    CommentLike findByUserAndComment(@Param("user") User user, @Param("comment") Comment comment);


}
