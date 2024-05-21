package efub.session.blog.follow.repository;

import efub.session.blog.account.domain.Account;
import efub.session.blog.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    // [?] existsByFollowerAndFollowing(Account follower, Account following);
    // [?]<[?]> findAllByFollower(Account follower);
    // [?]<[?]> findAllByFollowing(Account following);
    // [?] findByFollowerAndFollowing(Account follower, Account following);
    // [?] deleteByFollowId(Long followId);
}