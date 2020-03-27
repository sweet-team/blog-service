package lx.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lx.domain.JwtUser;
import lx.domain.User;
import lx.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        String role = user.getRole();
        JwtUser jwtUser = (JwtUser)authResult.getPrincipal();
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role.equals(Role.adminRole));
        response.setHeader("authentication",JwtTokenUtils.TOKEN_PREFIX+token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}

