package lx.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="lx_address")
@Data
public class Address {
    @Id
    private Long id;
    private String name;
    private String shortName;
    private String code;
    private Integer level;
    @ManyToOne
    private Address pid;

}
