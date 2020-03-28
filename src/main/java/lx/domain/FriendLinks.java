package lx.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="lx_friend_links")
@Data
public class FriendLinks {
    private Long url;
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "is_show")
    private Boolean show;
}
