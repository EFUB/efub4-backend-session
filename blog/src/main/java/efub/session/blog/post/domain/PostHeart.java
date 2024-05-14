package efub.session.blog.post.domain;

import efub.session.blog.account.domain.Account;
import lombok.Builder;


public class PostHeart {
    private Long id;

    private Post post;

    private Account writer;


    @Builder
    public PostHeart(Post post, Account account) {
        this.post = post;
        this.writer = account;
    }
}