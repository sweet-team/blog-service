package lx.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Data
@Entity(name="lx_articles")
public class Articles {
    @Id
    @GeneratedValue
    private Long id;
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleType type;
    private String title;
    private Long date;
    private String abstracts;
    @Lob
    private String context;
    @Lob
    private String markText;
    @Column(name = "is_show")
    private Boolean show;
}
