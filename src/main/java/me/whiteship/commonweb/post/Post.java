package me.whiteship.commonweb.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NamedQuery(name = "Post.findByTitle", query = "select p from Post as p where p.title = ?1")
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    private LocalDateTime created;
}
