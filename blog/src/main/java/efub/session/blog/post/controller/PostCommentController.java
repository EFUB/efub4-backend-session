package efub.session.blog.post.controller;

import efub.session.blog.comment.domain.Comment;
import efub.session.blog.comment.dto.CommentRequestDto;
import efub.session.blog.comment.dto.CommentResponseDto;
import efub.session.blog.comment.service.CommentService;
import efub.session.blog.post.dto.PostCommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class PostCommentController {

    private final CommentService commentService;

    /* 게시글에 댓글 생성 */
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable("postId") Long postId,
                                                            @RequestBody CommentRequestDto requestDto){
        Comment comment = commentService.saveComment(postId, requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommentResponseDto.of(comment));
    }

    /* 게시글의 댓글 목록 조회 */
    @GetMapping
    public ResponseEntity<PostCommentResponseDto> getPostCommentList(@PathVariable("postId") Long postId){
        List<Comment> commentList = commentService.findPostCommentList(postId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(PostCommentResponseDto.of(postId, commentList));
    }

}
