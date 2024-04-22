package efub.session.blog.account.controller;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.dto.AccountCommentResponseDto;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.comment.domain.Comment;
import efub.session.blog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts/{accountId}/comments")
public class AccountCommentController {

    private final AccountService accountService;
    private final CommentService commentService;

    /* 작성자별 댓글 목록 조회 */
    @GetMapping
    public ResponseEntity<AccountCommentResponseDto> getAccountCommentList(@PathVariable("accountId") Long accountId){
        Account writer = accountService.findAccountById(accountId);
        List<Comment> commentList = commentService.findAccountCommentList(writer);

        return ResponseEntity.status(HttpStatus.OK)
                .body(AccountCommentResponseDto.of(writer, commentList));
    }
}







