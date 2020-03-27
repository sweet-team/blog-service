package lx.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name="lx_skill")
@Data
public class Skill {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String img;
    private Integer level;
    private String intro;
    @Column(name = "is_show")
    private Boolean show;
    @ManyToOne
    private BaseInfo baseInfo;
}
