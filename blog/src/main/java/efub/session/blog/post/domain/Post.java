package efub.session.blog.post.domain;


import efub.session.blog.account.domain.Account;
import efub.session.blog.comment.domain.Comment;
import efub.session.blog.global.entity.BaseTimeEntity;
import efub.session.blog.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", updatable = false)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "account_id", updatable = false)
    private Account account;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 1000)
    private String content;

    /* mappedBy : 연관관계의 주인 */
    /* cascade : 엔티티 삭제 시 연관된 엔티티의 처리 방식. */
    /* orphanRemoval : 고아 객체의 처리 방식 */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    @Builder
    public Post(Account account, String title, String content){
        this.account = account;
        this.title = title;
        this.content = content;
    }

    public void update(PostRequestDto dto, Account account){
        this.account = account;
        this.title = title;
        this.content = content;
    }
}
