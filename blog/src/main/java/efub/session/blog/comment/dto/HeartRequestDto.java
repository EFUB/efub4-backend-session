package efub.session.blog.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeartRequestDto {
    @NotNull(message = "작성자는 필수로 입력되어야 합니다.")
    private Long accountId;

    public HeartRequestDto(Long accountId) {
        this.accountId = accountId;
    }
}