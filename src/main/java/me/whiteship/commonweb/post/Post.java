package me.whiteship.commonweb.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    private LocalDateTime created;
}
