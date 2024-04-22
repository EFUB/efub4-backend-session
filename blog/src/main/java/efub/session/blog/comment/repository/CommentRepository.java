package efub.session.blog.comment.repository;

import efub.session.blog.account.domain.Account;
import efub.session.blog.comment.domain.Comment;
import efub.session.blog.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
    List<Comment> findAllByWriter(Account account);
}
