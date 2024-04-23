package efub.session.blog.account.dto;

import efub.session.blog.account.domain.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestDto {
    @NotBlank(message = "이메일은 필수입니다.")  // 해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    @Email(message = "유효하지 않은 이메일 형식입니다.",
            regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.") // 해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!.?,])[A-Za-z\\d!.?,]{2,16}$",
            message = "16자 이내의 영문자 및 숫자와 ?,!,., , 특수문자로 입력해주세요.")
    private String password;

    @NotBlank(message = "닉네임은 필수입니다. ") // 해당 값이 null이 아니고, 공백(""과 " " 모두 포함)이 아닌지 검증
    private String nickname;

    @Builder
    public SignUpRequestDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public Account toEntity() {
        return Account.builder()
                .email(this.email)
                .password(this.password)
                .nickname(this.nickname)
                .bio("안녕하세요")
                .build();
    }
}