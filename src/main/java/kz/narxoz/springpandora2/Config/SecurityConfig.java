package kz.narxoz.springpandora2.Config;
import kz.narxoz.springpandora2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true ,securedEnabled = true,proxyTargetClass = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{

        auth.userDetailsService(userService);
    }

    @Override
    protected  void configure(HttpSecurity http) throws  Exception{
        http.exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().antMatchers("/","/css/**","/js/**").permitAll();
        http.formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .loginProcessingUrl("/auth").permitAll()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/example");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

//        http.csrf().disable();



    }
}
