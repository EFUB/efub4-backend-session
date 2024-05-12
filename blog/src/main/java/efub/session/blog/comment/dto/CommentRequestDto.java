package efub.session.blog.comment.dto;

import efub.session.blog.comment.domain.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequestDto {
    private Long accountId;
    private String content;
}
