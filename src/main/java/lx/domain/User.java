package lx.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="lx_use")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String role;
}
