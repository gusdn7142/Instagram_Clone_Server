package com.instagram.domain.user.domain;


import com.instagram.domain.chat.domain.Chat;
import com.instagram.domain.comment.domain.Comment;
import com.instagram.domain.commentLike.domain.CommentLike;
import com.instagram.domain.follow.domain.Follow;
import com.instagram.domain.followReq.domain.FollowReq;
import com.instagram.domain.model.DataStatus;
import com.instagram.domain.post.domain.Post;
import com.instagram.domain.postLike.domain.PostLike;
import lombok.*;
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
@DynamicInsert   //null인 필드 제외
@DynamicUpdate   //null인 필드 제외
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;  //인덱스

    @Column (nullable=false, columnDefinition="varchar(61)")
    private String name;  //이름

    @Column (nullable=false, columnDefinition="varchar(61)")
    private String nickName;  //사용자 이름ㅊㅊㅊ

    @Column (nullable=false, columnDefinition="varchar(20)")
    private String phone;  //전화번호

    @Column (nullable=false,columnDefinition ="varchar(40)")
    private String email;  //이메일

    @Column (nullable=false, columnDefinition ="varchar(200)")
    private String password;  //패스워드

    @Column (nullable=false, columnDefinition ="DATE default (CURRENT_DATE)")
    private Date birthDay;  //생일

    @Column (nullable=true, columnDefinition ="varchar(200) default 'https://mblogthumb-phinf.pstatic.net/20150427_261/ninevincent_1430122791768m7oO1_JPEG/kakao_1.jpg?type=w2'")
    private String image;   //이미지 URL

    @Column (nullable=true, columnDefinition ="varchar(50)")
    private String webSite;  //웹사이트

    @Column (nullable=true, columnDefinition ="varchar(100)")
    private String introduction;  //소개

    @Column (nullable=true, columnDefinition ="varchar(10) default 'OPEN'")
    @Enumerated(EnumType.STRING)
    //private String hiddenState;  //계정 공개 유무
    private AccountHiddenState accountHiddenState;  //계정 공개 유무

    @Column (nullable=false, columnDefinition ="varchar(10)")
    @Enumerated(EnumType.STRING)
    private PrivacyPolicyStatus privacyPolicyStatus;  //개인정보 처리방침 동의여부

    @Column (nullable=true, columnDefinition ="varchar(20) default 'LOCAL'")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;  //계정 타입

    @Column (columnDefinition = "varchar(10) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private DataStatus status; //데이터 상태 (INACTIVE or ACTIVE)

    @Column (columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  //생성 시각

    @Column (columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt; //갱신 시각

    @Builder
    public User (String name,
                 String nickName,
                 String phone,
                 String email,
                 String password,
                 Date birthDay,
                 String image,
                 String webSite,
                 String introduction,
                 AccountHiddenState accountHiddenState,
                 PrivacyPolicyStatus privacyPolicyStatus,
                 AccountType accountType,
                 DataStatus status,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt){
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.birthDay = birthDay;
        this.image = image;
        this.webSite = webSite;
        this.introduction = introduction;
        this.accountHiddenState = accountHiddenState;
        this.privacyPolicyStatus = privacyPolicyStatus;
        this.accountType = accountType;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(){ }

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Chat> receiverChats = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    private List<Chat> senderChats = new ArrayList<>();

    @OneToMany(mappedBy = "followee")
    private List<Follow> followeeFollows = new ArrayList<>();

    @OneToMany(mappedBy = "follower")
    private List<Follow> followerFollows = new ArrayList<>();

    @OneToMany(mappedBy = "reqFollowee")
    private List<FollowReq> reqFolloweeFollowReqs = new ArrayList<>();

    @OneToMany(mappedBy = "reqFollower")
    private List<FollowReq> reqFollowerFollowReqs = new ArrayList<>();

    public void deleteUser(){
        this.status = DataStatus.INACTIVE;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateNickName(String nickName){
        this.nickName = nickName;
    }

    public void updateWebSite(String webSite){
        this.webSite = webSite;
    }

    public void updateIntroduction(String introduction){
        this.introduction = introduction;
    }

    public void updateHiddenState(AccountHiddenState accountHiddenState){
        this.accountHiddenState = accountHiddenState;
    }


}
