package efub.session.blog.account.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountUpdateRequestDto {
    private String bio;

    @NotBlank(message = "닉네임은 필수로 입력해야 합니다.")
    private String nickname;

    @Builder
    public AccountUpdateRequestDto(String bio, String nickname) {
        this.bio = bio;
        this.nickname = nickname;
    }
}
