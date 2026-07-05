package me.whiteship.commonweb.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/posts/{id}")
//    public String getPost(@PathVariable("id") Long id) {
//        Optional<Post> byId = postRepository.findById(id);
//        return byId.get().getTitle();
//    }
    public String getPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }
}
