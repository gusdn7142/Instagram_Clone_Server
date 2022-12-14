package com.instagram.domain.postLike.dao;

import com.instagram.domain.post.domain.Post;
import com.instagram.domain.postLike.domain.PostLike;
import com.instagram.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface PostLikeDao extends JpaRepository<PostLike, Long> {


    /* 19. postLikeIdx 통해 PostLike 엔티티 조회  */
    @Query(value="select pl from PostLike pl where pl.idx = :postLikeIdx and pl.status = 'ACTIVE'")
    PostLike findByIdx(@Param("postLikeIdx") Long postLikeIdx);


    /* 18. user 객체와 post 객체를 통해 postLike 엔티티 조회  */
    @Query(value="select pl from PostLike pl where pl.user = :user and pl.post = :post and pl.status = 'ACTIVE'")
    PostLike findByUserAndPost(@Param("user") User user, @Param("post") Post post);

}
