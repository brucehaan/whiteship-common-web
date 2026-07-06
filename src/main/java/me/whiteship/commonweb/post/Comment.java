package me.whiteship.commonweb.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
@Entity
@Getter
@Setter
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
