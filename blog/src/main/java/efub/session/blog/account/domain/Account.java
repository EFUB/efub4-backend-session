package efub.session.blog.account.domain;

import efub.session.blog.comment.domain.Comment;
import efub.session.blog.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static efub.session.blog.account.domain.AccountStatus.REGISTERED;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", updatable = false)
    private Long accountId;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private String encodedPassword;

    @Column(nullable = false, updatable = false, length = 16)
    private String nickname;

    private String bio;

    @Enumerated(EnumType.STRING) // enum 타입
    private AccountStatus status;

    /* mappedBy : 연관관계의 주인 */
    /* cascade : 엔티티 삭제 시 연관된 엔티티의 처리 방식. */
    /* orphanRemoval : 고아 객체의 처리 방식 */


    @Builder // 객체 생성
    public Account(String email, String password, String nickname, String bio) {
        this.email = email;
        this.encodedPassword = password;
        this.nickname = nickname;
        this.bio = bio;
        this.status = REGISTERED;
    }

    //닉네임 수정하기
    public void updateAccount(String bio, String nickname) {
        this.bio = bio;
        this.nickname = nickname;
    }

    //회원 탈퇴
    public void withdrawAccount() {
        this.status = AccountStatus.UNREGISTERED;
    }

}
