package me.whiteship.commonweb.post;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    void getComment() {
//        Post post = new Post();
//        post.setTitle("jpa");
//        Post savedPost = postRepository.save(post);
//
//        Comment comment = new Comment();
//        comment.setComment("comment");
//        comment.setPost(savedPost);
//        commentRepository.save(comment);

//        Optional<Comment> byId = commentRepository.findById(1l);
//        log.info("{}", byId.get().getPost());

        commentRepository.getReferenceById(1l);
        commentRepository.findById(1l);
    }

}