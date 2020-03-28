package lx.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity(name="lx_address")
@Data
public class Address {
    @Id
    private Long id;
    private String name;
    private String shortName;
    private String code;
    private Integer level;
    @ManyToOne(fetch = FetchType.LAZY)
    private Address pid;

}
