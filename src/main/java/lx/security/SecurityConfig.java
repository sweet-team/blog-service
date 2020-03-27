package lx.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        super.configure(auth);
    }

    /**
     * 判断哪个url请求安全
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/**").authenticated()
                .antMatchers(HttpMethod.POST,"/**").authenticated()
                .antMatchers(HttpMethod.PUT,"/**").authenticated()
                .antMatchers("/login").permitAll()
                .and().addFilter(new JWTLoginFilter(authenticationManager()))
                    .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ;

    }

}
