package lx.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class JwtUser implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String role;
    public JwtUser(){}
    public JwtUser(User user){
        this.id =user.getId();
        this.username=user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRole() {
        return role;
    }
}
