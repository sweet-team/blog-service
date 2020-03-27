package lx.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="lx_comment")
public class Experience {
    @Id
    @GeneratedValue
    private Integer id;

    private String post;
    private String content;
    private Long startTime;
    private Long endTime;
    @Column(name = "is_show")
    private Boolean show;
    @OneToOne
    private Address place;
}
