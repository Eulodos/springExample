package pl.sda.springtraining.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/products/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/console/*").permitAll()
                .anyRequest().permitAll()
                .and().csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("loginEmail")
                .passwordParameter("loginPassword")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=1");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin@admin.pl")
                .password(passwordEncoder.encode("admin12345"))
                .roles("ADMIN")
                .and()
                .withUser("user@user.pl")
                .password(passwordEncoder.encode("user12345"))
                .roles("USER");

        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, 1 FROM user u WHERE u.email=?")
                .authoritiesByUsernameQuery("SELECT u.email, r.role_name,1 FROM user u JOIN user_role ur ON u.id=ur.user_id JOIN role r ON r.id=ur.roles_id WHERE u.email=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }
}
