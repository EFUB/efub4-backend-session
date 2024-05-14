package efub.session.blog.comment.controller;

import efub.session.blog.account.service.AccountService;
import efub.session.blog.comment.service.CommentHeartService;
import efub.session.blog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final AccountService accountService;
    private final CommentHeartService commentHeartService;


    // 좋아요 등록
//    public String createCommentLike(@PathVariable final Long commentId, @RequestBody final AccountInfoRequestDto requestDto) {
//    }

    // 좋아요 삭제
//    public String deleteCommentLike(@PathVariable final Long commentId, @RequestParam final Long accountId) {
//    }

    // 댓글 수정
//    public CommentResponseDto updatePostComment(@PathVariable final Long commentId, @RequestBody @Valid final CommentRequestDto requestDto) {
//    }

    // 댓글 삭제
//    public String deleteComment(@PathVariable final Long commentId) {
//    }
}