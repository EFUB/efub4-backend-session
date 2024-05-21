package efub.session.blog.follow.service;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.follow.domain.Follow;
import efub.session.blog.follow.dto.FollowRequestDto;
import efub.session.blog.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    public final AccountService accountService;

//    public [?] add([?], [?]){
//        Account follower = accountService.findAccountById([?]);
//        Account following = accountService.findAccountById([?]);
//        // Follow follow = ...;
//        // return ...;
//    }

//    @Transactional(readOnly = true)
//    public [?] isFollowing([?], [?]){
//        Account follower = accountService.findAccountById([?]);
//        Account following = accountService.findAccountById([?]);
//        // return ...;
//    }

//    @Transactional(readOnly = true)
//    public [?]<[?]> findAllByFollowerId([?]) {
//        Account findAccount = accountService.findAccountById([?]);
//        return ...;
//    }

//    @Transactional(readOnly = true)
//    public [?]<[?]> findAllByFollowingId([?]) {
//        Account findAccount = accountService.findAccountById([?]);
//        return ...;
//    }

//    @Transactional(readOnly = true)
//    public [?] findByFollowerIdAndFollowingId([?], [?]) {
//        Account follower = accountService.findAccountById([?]);
//        Account following = accountService.findAccountById([?]);
//        return ...;
//    }

//    public void delete([?], [?]) {
//        Follow findFollow = ...;
//        return ...;
//    }
}