package lx.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity(name="lx_base_info")
public class BaseInfo {
    @Id
    private Integer id;
    private String name;
    private Long age;
    @OneToOne
    private Address place;

    private String college;
    private String major;
    private String direction;
    private String motto;
    private String proUrl;
    private String collegeType;
    private String evaluation;
    private String email;
    private String weChat;

}
