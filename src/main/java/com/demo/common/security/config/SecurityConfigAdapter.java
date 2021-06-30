package com.demo.common.security.config;


import com.demo.common.security.UserDetailServiceImpl;
import com.demo.common.security.handle.FailureLoginHandle;
import com.demo.common.security.handle.SuccessLoginHandle;
import com.demo.common.security.validate.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ：msj
 * @date ：Created in 2021/5/21 10:16
 * @description：security 配置
 * @modified By：`
 * @version: 1.0
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)   //默认是禁用注解的，要想开启注解，需要在继承WebSecurityConfigurerAdapter的类上加@EnableGlobalMethodSecurity注解
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessLoginHandle successLoginHandle;

    @Autowired
    private FailureLoginHandle failureLoginHandle;

    @Bean
    ValidateCodeFilter validateCodeFilter() {
        return new ValidateCodeFilter();
    }

    @Bean
    UserDetailsService customDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.userDetailsService(customDetailsService()).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence password) {
                return MD5Util.encode((String) password);
            }

            @Override
            public boolean matches(CharSequence password, String s) {
                return s.matches(MD5Util.encode((String) password));
            }
        });*/
        /*auth.userDetailsService(customDetailsService()).passwordEncoder(new BCryptPasswordEncoder());*/
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/admin/image/**",
                "/admin/lib/**",
                "/admin/static/**",
                "/admin/temp/**","/ueditor/1.4.3/**")
                .antMatchers("/doc.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http/*.addFilterBefore(validateCodeFilter(), UsernamePasswordAuthenticationFilter.class)*/  //在用户名和密码验证前进行验证码的验证
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index")
                .successHandler(successLoginHandle)
                .failureHandler(failureLoginHandle)
                .and()
                .authorizeRequests()
                .antMatchers("/login","/imageCode/**","/clearSession","/imageCode**","/dev-api")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and()
                .headers()
                .frameOptions()
                .disable()
        .and()
        .csrf()
        .disable();
    }
}
