package lx.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "lx_article_type")
@Data
public class ArticleType {
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    private String id;
    private String name;
    @Column(name = "is_show")
    private Boolean show;

}
