package efub.session.blog.comment.domain;

import efub.session.blog.account.domain.Account;
import lombok.Builder;

public class CommentHeart {
    private Long id;

    private Comment comment;

    private Account writer;

    @Builder
    public CommentHeart(Comment comment, Account account) {
        this.comment = comment;
        this.writer = account;
    }
}
