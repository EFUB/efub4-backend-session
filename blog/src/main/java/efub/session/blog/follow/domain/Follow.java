package efub.session.blog.follow.domain;

import efub.session.blog.account.domain.Account;
import efub.session.blog.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 어노테이션들을 작성해 보아요 (3개)
public class Follow extends BaseTimeEntity {

    // 어노테이션 3개
    private Long followId;

    // 어노테이션 2개
    private Account follower;

    // 어노테이션 2개
    private Account following;

    // Builder 메소드 패턴으로 작성 (또는 클래스에 @Builder 붙임)
}