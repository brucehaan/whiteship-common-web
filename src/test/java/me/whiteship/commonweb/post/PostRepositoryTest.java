package me.whiteship.commonweb.post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);// persist

        assertThat(em.contains(post)).isTrue();
        assertThat(em.contains(savedPost)).isTrue();
        assertThat(savedPost == post);

        Post postUpdate = new Post();
        postUpdate.setId(1l);
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate);// merge -> update, JPA대신 hibernate로 값 변경. 새로운 객체인지 다른 객체인지, 새로우면 merge,

        assertThat(em.contains(updatedPost)).isTrue();
        assertThat(em.contains(postUpdate)).isFalse();
        assertThat(updatedPost == postUpdate);

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        return postRepository.save(post); // persist
    }

    @Test
    void findByTitle() {
        savePost();

        List<Post> all = postRepository.findByTitle("Spring", Sort.by("title"));
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void updateTitle() {
        Post spring = savePost();
//        String title = "hibernate";
//        int update = postRepository.updateTitle(title, spring.getId());
//        assertThat(update).isEqualTo(1);
//
//        Optional<Post> byId = postRepository.findById(spring.getId());
//        assertThat(byId.get().getTitle()).isEqualTo(title);
        spring.setTitle("hibernate");

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo("hibernate");
    }
}