package efub.session.blog.comment.service;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.comment.domain.Comment;
import efub.session.blog.comment.dto.CommentRequestDto;
import efub.session.blog.comment.repository.CommentRepository;
import efub.session.blog.post.domain.Post;
import efub.session.blog.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final AccountService accountService;
    private final PostService postService;
    private final CommentRepository commentRepository;

    /* 댓글 생성 */
    public Comment saveComment(Long postId, CommentRequestDto requestDto) {
        Account writer = accountService.findAccountById(requestDto.getAccountId());
        Post post = postService.findPostById(postId);

        Comment comment = Comment.builder()
                .content(requestDto.getContent())
                .writer(writer)
                .post(post)
                .build();
        commentRepository.save(comment);

        return comment;
    }

    /* 게시글의 댓글 목록 조회 */
    public List<Comment> findPostCommentList(Long postId) {
        Post post = postService.findPostById(postId);
        return commentRepository.findAllByPost(post);
    }
}
