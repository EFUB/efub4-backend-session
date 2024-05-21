package efub.session.blog.follow.controller;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.follow.domain.Follow;
import efub.session.blog.follow.dto.FollowListResponseDto;
import efub.session.blog.follow.dto.FollowRequestDto;
import efub.session.blog.follow.dto.FollowStatusResponseDto;
import efub.session.blog.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;
    private final AccountService accountService;

//    @PostMapping("/{accountId}")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public FollowStatusResponseDto addFollow([?], [?]) {
////        Long id = ;
////        Boolean isFollow = ;
////        Account findAccount = ;
////        return new ...;
//    }

//    @GetMapping("/{accountId}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public FollowListResponseDto getFollowList([?]){
//        List<Follow> followerList = ;
//        List<Follow> followingList = ;
//        return ...;
//    }

//    @GetMapping("/{accountId}/search")
//    @ResponseStatus(value = HttpStatus.OK)
//    public FollowStatusResponseDto searchAccount([?], [?]){
//        Account searchAccount = ...;
//        Boolean isFollow = ...;
//        return new ...;
//    }

//    @DeleteMapping("/{accountId}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public FollowStatusResponseDto deleteFollow([?], [?]){
//        // 삭제
//        // 팔로우했던 계정 찾기
//        // 팔로잉 여부 재확인
//        return new ...;
//    }

}
