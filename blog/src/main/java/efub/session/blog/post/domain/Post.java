package efub.session.blog.post.domain;


import efub.session.blog.account.domain.Account;
import efub.session.blog.global.entity.BaseTimeEntity;
import efub.session.blog.post.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
