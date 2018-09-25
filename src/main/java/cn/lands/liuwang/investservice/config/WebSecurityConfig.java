package cn.lands.liuwang.investservice.config;

import cn.lands.liuwang.investservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/lottery/**", "/css/**", "/js/**", "/images/**", "/web/about").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/web/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //开启跨站请求 不关闭会导致其他客户端无法访问
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);//配置自定义userDetailService
    }
}
