package com.multiristorante.app.backend.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.multiristorante.app.backend.service.UsuarioServiceInterface;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    
    private final UsuarioServiceInterface userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UsuarioServiceInterface userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.GET,"/restaurantes/**").permitAll()
        .antMatchers(HttpMethod.GET,"/productos/**").permitAll()
        .antMatchers(HttpMethod.GET,"/productos").permitAll()
        .antMatchers(HttpMethod.GET,"/menus/**").permitAll()
        .antMatchers(HttpMethod.GET,"/files/**").permitAll()
        .antMatchers(HttpMethod.GET,"/api/files").permitAll()
        .antMatchers(HttpMethod.GET,"/comentarios/**").permitAll()
        .antMatchers(HttpMethod.POST,"/usuarios", "/carrito").permitAll().anyRequest().authenticated()
        .and().addFilter(getAuthenticationFilter()).addFilter(new AuthorizationFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception{
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/usuarios/login");
        return filter;
    }

}
