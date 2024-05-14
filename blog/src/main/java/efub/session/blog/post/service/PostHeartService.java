package efub.session.blog.post.service;

import efub.session.blog.account.domain.Account;
import efub.session.blog.account.service.AccountService;
import efub.session.blog.post.domain.Post;
import efub.session.blog.post.domain.PostHeart;
import efub.session.blog.post.repository.PostHeartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostHeartService {

    private final PostHeartRepository postHeartRepository;
    private final PostService postService;
    private final AccountService accountService;

    // 좋아요 등록
//    public void create(Long postId, Long accountId) {
//    }

    // 좋아요 삭제
//    public void delete(Long postId, Long accountId) {
//    }

    // 좋아요 상태 확인
//    public boolean isHeart(Long accountId, Post post){
//    }

    @Transactional(readOnly = true)
    public boolean isExistsByWriterAndPost(Account account, Post post) {
        return postHeartRepository.existsByWriterAndPost(account, post);
    }

    @Transactional(readOnly = true)
    public Integer countPostHeart(Post post) {
        Integer count = postHeartRepository.countByPost(post);
        return count;
    }
}