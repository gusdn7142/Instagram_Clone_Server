package com.instagram.global.error;

import lombok.Getter;




@Getter
public enum BasicResponseStatus {

    /**
     * 요청 성공
     */
    SUCCESS("SUCCESS", "NOT_ERROR", "요청 성공"),


    /**
     * user 도메인
     */

    REQ_ERROR_INVALID_PHONE("FAIL","REQ_ERROR_INVALID_PHONE","전화번호 형식 오류"),
    REQ_ERROR_INVALID_NAME("FAIL","REQ_ERROR_INVALID_NAME","이름 형식 오류"),
    REQ_ERROR_INVALID_PASSWORD("FAIL","REQ_ERROR_INVALID_PASSWORD","비밀번호 형식 오류"),
    REQ_ERROR_INVALID_BIRTHDAY("FAIL","REQ_ERROR_INVALID_BIRTHDAY","생일 형식 오류"),
    REQ_ERROR_INVALID_PRIVACY_POLICY_STATUS("FAIL","REQ_ERROR_INVALID_PRIVACY_POLICY_STATUS","개인정보 처리방침 미동의 (Need : AGREE)"),
    REQ_ERROR_INVALID_NICK_NAME("FAIL","REQ_ERROR_INVALID_NICK_NAME","닉네임 형식 오류"),
    REQ_ERROR_INVALID_ACCOUNT_HIDDEN_STATE("FAIL","REQ_ERROR_INVALID_ACCOUNT_HIDDEN_STATE","계정 공개상태 형식 오류 (Need : OPEN or PRIVATE)"),


    RES_ERROR_EXIST_PHONE("FAIL","RES_ERROR_EXISTS_PHONE","전화번호 중복 오류"),
    RES_ERROR_EXIST_NICK_NAME("FAIL","RES_ERROR_EXISTS_NICK_NAME","닉네임 중복 오류"),
    RES_ERROR_JOIN_CHECK("FAIL","RES_ERROR_JOIN_CHECK","가입되지 않은 유저"),
    RES_ERROR_MATCH_FAIL_PASSWORD("FAIL","RES_ERROR_MATCH_FAIL_PASSWORD_","잘못된 비밀번호"),
    RES_ERROR_NOT_EXIST_USER("FAIL","RES_ERROR_NOT_EXIST_USER","존재하지 않는 사용자 계정"),





    DATABASE_ERROR_CREATE_USER("FAIL", "DATABASE_ERROR_CREATE_USER", "DB에 사용자 등록 실패"),
    RES_ERROR_LOGIN_USER("FAIL", "RES_ERROR_LOGIN_USER", "로그인 실패"),

    DATABASE_ERROR_GET_USER("FAIL", "DATABASE_ERROR_GET_USER", "DB에서 사용자 정보 조회 실패"),
    DATABASE_ERROR_DELETE_USER("FAIL", "DATABASE_ERROR_DELETE_USER", "회원 탈퇴 실패"),




    /**
     * post 도메인
     */
    REQ_ERROR_INVALID_POSTS_CONTENT("FAIL","REQ_ERROR_INVALID_POSTS_CONTENT","게시글 내용 형식 오류 (최대 1000자 입력 가능)"),
    REQ_ERROR_INVALID_POSTS_IMAGE_NUMBER("FAIL","REQ_ERROR_INVALID_POSTS_IMAGE_NUMBER","이미지 번호 형식 오류 (최대 10개 입력 가능)"),
    REQ_ERROR_INVALID_POSTS_IMAGE_FILE("FAIL","REQ_ERROR_INVALID_POSTS_IMAGE_FILE","이미지 파일 입력 오류 (최대 10개 입력 가능)"),
    REQ_ERROR_INVALID_POSTS_IMAGE_FILE_EXTENSION("FAIL","REQ_ERROR_INVALID_POSTS_IMAGE_FILE_EXTENSION","이미지 파일 형식 오류 (허용 확장자 : .gif, .jpg, .jpeg, .png)"),
    REQ_ERROR_INVALID_POSTS_IMAGE_FILE_SIZE("FAIL","REQ_ERROR_INVALID_POSTS_IMAGE_FILE_SIZE","이미지 파일 크기 오류 (최대 10MB 까지 업로드 가능)"),
    REQ_ERROR_DIFFERENT_SIZE_IMAGE_FILE_AND_IMAGE_NUMBER("FAIL","REQ_ERROR_DIFFERENT_SIZE_IMAGE_FILE_AND_IMAGE_NUMBER","이미지 파일과 이미지 번호 수 불일치"),

    DATABASE_ERROR_FAIL_GET_POSTS("FAIL","DATABASE_ERROR_FAIL_GET_POSTS","DB에서 게시글 조회 실패"),


    /**
     * AccessToken 관련
     */
    ERROR_FAIL_ISSUE_ACCESS_TOKEN("FAIL","ERROR_FAIL_ISSUE_ACCESS_TOKEN","accessToken 발급 실패"),
    ERROR_EMPTY_ACCESS_TOKEN("FAIL", "ERROR_EMPTY_ACCESS_TOKEN", "accessToken 미입력 오류"),
    ERROR_INVALID_ACCESS_TOKEN("FAIL", "ERROR_INVALID_ACCESS_TOKEN", "accessToken 변조 혹은 만료"),
    ERROR_INVALID_USER_ACCESS_TOKEN("FAIL","ERROR_INVALID_USER_ACCESS_TOKEN","권한이 없는 유저의 접근"),


    DATABASE_ERROR_CREATE_POST("FAIL","DATABASE_ERROR_CREATE_POST","DB에 게시글 등록 실패"),


    /**
     * AWS S3 관련
     */
    S3_ERROR_UPLOAD_FILE("FAIL","S3_ERROR_UPLOAD_FILE","S3에 파일 업로드 실패"),



    /**
     * DB 오류, 서버 오류
     */
    DATABASE_ERROR("FAIL", "DATABASE_ERROR", "DB에서 데이터 조회 실패"),
    SERVER_ERRER("FAIL", "SERVER_ERROR", "서버에서 오류 발생"),


    DATABASE_ERROR_MODIFY_FAIL_USER_NAME("FAIL", "DATABASE_ERROR_MODIFY_FAIL_USER_NAME", "이름 변경 오류"),
    DATABASE_ERROR_MODIFY_FAIL_USER_NICKNAME("FAIL", "DATABASE_ERROR_MODIFY_FAIL_USER_NICKNAME", "닉네임 변경 오류"),
    DATABASE_ERROR_MODIFY_FAIL_USER_WEBSITE("FAIL", "DATABASE_ERROR_MODIFY_FAIL_USER_WEBSITE", "웹사이트 변경 오류"),
    DATABASE_ERROR_MODIFY_FAIL_USER_INTRODUCTION("FAIL", "DATABASE_ERROR_MODIFY_FAIL_USER_INTRODUCTION", "소개글 변경 오류"),
    DATABASE_ERROR_MODIFY_FAIL_USER_ACCOUNT_HIDDEN_STATE("FAIL", "DATABASE_ERROR_MODIFY_FAIL_USER_ACCOUNT_HIDDEN_STATE", "계정공개 유무 변경 오류");





    private String status;
    private String code;
    private String message;



    private BasicResponseStatus(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }



}