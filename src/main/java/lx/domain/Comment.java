package lx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name="lx_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String message;
    private Long date;
    @Column(name = "is_article")
    private Boolean isArticle;
    @ManyToOne
    private Articles article;
}
