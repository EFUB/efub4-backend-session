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

    @PostMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public FollowStatusResponseDto addFollow(@PathVariable final Long accountId,
                                             @RequestBody final FollowRequestDto requestDto) {
        Long id = followService.add(accountId, requestDto);
        Boolean isFollow = followService.isFollowing(accountId, requestDto.getFollowingId());
        Account findAccount = accountService.findAccountById(requestDto.getFollowingId());
        return new FollowStatusResponseDto(findAccount, isFollow);
    }

    @GetMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public FollowListResponseDto getFollowList(@PathVariable final Long accountId){
        List<Follow> followerList = followService.findAllByFollowingId(accountId);
        List<Follow> followingList = followService.findAllByFollowerId(accountId);
        return FollowListResponseDto.of(followerList, followingList);
    }

    @GetMapping("/{accountId}/search")
    @ResponseStatus(value = HttpStatus.OK)
    public FollowStatusResponseDto searchAccount(@PathVariable final Long accountId,
                                                 @RequestParam final String email){
        Account searchAccount = accountService.findAccountByEmail(email);
        Boolean isFollow = followService.isFollowing(accountId, searchAccount.getAccountId());
        return new FollowStatusResponseDto(searchAccount, isFollow);
    }

    @DeleteMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public FollowStatusResponseDto deleteFollow(@PathVariable final Long accountId,
                                                @RequestParam final Long followingId){
        followService.delete(accountId, followingId);
        Account findAccount = accountService.findAccountById(followingId);
        Boolean isFollow = followService.isFollowing(accountId, followingId);
        return new FollowStatusResponseDto(findAccount, isFollow);
    }

}
