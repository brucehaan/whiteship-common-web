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
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("12341234");
        comment.setPost(savedPost);
        comment.setUp(19);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId(), CommentSummary.class).forEach(c -> {
            log.info("=======================");
            log.info(c.getVotes());
        });
    }

}