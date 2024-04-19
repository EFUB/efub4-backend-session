package efub.session.blog.post.controller;


import efub.session.blog.post.domain.Post;
import efub.session.blog.post.dto.AllPostResponseDto;
import efub.session.blog.post.dto.PostRequestDto;
import efub.session.blog.post.dto.PostResponseDto;
import efub.session.blog.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /* 게시글 작성 */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostResponseDto createNewPost(@RequestBody @Valid final PostRequestDto dto){
        Post savedPost = postService.createNewPost(dto);
        return PostResponseDto.from(savedPost, savedPost.getAccount().getNickname());
    }

    /* 게시글 조회_전체 */
    @GetMapping
    public AllPostResponseDto getAllPosts(){
        List<PostResponseDto> list = new ArrayList<>();
        List<Post> posts = postService.findAllPosts();
        for(Post post : posts){
            PostResponseDto dto = PostResponseDto.from(post, post.getAccount().getNickname());
            list.add(dto);
        }

        long count = postService.countAllPosts();

        return new AllPostResponseDto(list, count);
    }

    /* 게시글 조회_1개 */
    @GetMapping("{id}")
    public PostResponseDto getOnePost(@PathVariable(name = "id")Long id){
        Post post = postService.findPostById(id);
        return PostResponseDto.from(post, post.getAccount().getNickname());
    }

    /* 게시글 수정 */
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable(name = "id") Long id,
                                      @RequestBody @Valid final PostRequestDto dto){
        Long postId = postService.updatePost(id, dto);
        Post post = postService.findPostById(postId);
        return PostResponseDto.from(post, post.getAccount().getNickname());
    }

    /* 게시글 삭제 */
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable(name = "id") Long id,
                             @RequestParam(name = "accountId") Long accountId){
        postService.deletePost(id, accountId);

        return "성공적으로 삭제되었습니다.";
    }
}
