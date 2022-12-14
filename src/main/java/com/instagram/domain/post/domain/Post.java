package com.instagram.domain.post.domain;


import com.instagram.domain.model.DataStatus;
import com.instagram.domain.user.domain.AccountHiddenState;
import com.instagram.domain.user.domain.AccountType;
import com.instagram.domain.user.domain.PrivacyPolicyStatus;
import com.instagram.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
//@Setter

@Entity
@DynamicInsert   //jnull인 필드 제외
@DynamicUpdate   //null인 필드 제외
@Table(name = "post")   //엔티티와 매핑할 테이블을 지정
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;  //인덱스

    @Column (nullable=false, columnDefinition="varchar(3002)")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)  //실무에서는 n+1 쿼리조회 문제 때문에 LAZY(지연 로딩만 사용.) cascade = CascadeType.ALL
    @JoinColumn(name = "user_idx")
    private User user;  //글쓴이 인덱스

    @Column (nullable=true, columnDefinition ="varchar(10) default 'VISIBLE'")
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;   //게시물 상태 (VISIBLE or UNVISIBLE)

    @Column (columnDefinition = "varchar(10) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private DataStatus status;    //데이터 상태 (INACTIVE or ACTIVE)

    @Column (columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  //생성 시각

    @Column (columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt; //갱신 시각

    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();

    public Post deletePost(){
        this.status = DataStatus.INACTIVE;
        return this;
    }

    @Builder
    public Post (String content,
                 User user,
                 PostStatus postStatus,
                 DataStatus status,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt){
        this.content = content;
        this.user = user;
        this.postStatus = postStatus;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Post(){ }

    public void updateContent(String content){
        this.content = content;
    }
}
