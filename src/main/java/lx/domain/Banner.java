package lx.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="lx_banner")
@Data
public class Banner {
    @Id
    @GeneratedValue
    private Long id;

    private String url;
    private String name;
    private String img;
    private Long date;
    @Column(name = "is_show")
    private Boolean show;
    @Column(name = "is_out")
    private Boolean out;
}
