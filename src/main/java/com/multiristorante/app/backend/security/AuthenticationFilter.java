package com.multiristorante.app.backend.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiristorante.app.backend.SpringApplicationContext;
import com.multiristorante.app.backend.Models.requests.UsuarioLoginRequestModel;
import com.multiristorante.app.backend.Shared.dto.UsuarioDto;
import com.multiristorante.app.backend.service.UsuarioServiceInterface;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            UsuarioLoginRequestModel userModel = new ObjectMapper().readValue(request.getInputStream(),
            UsuarioLoginRequestModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(),
                    userModel.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authentication) throws IOException, ServletException {

        String username = ((User) authentication.getPrincipal()).getUsername();

        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstans.EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS512, SecurityConstans.getTokenSecret()).compact();

        UsuarioServiceInterface userService = (UsuarioServiceInterface)SpringApplicationContext.getBean("usuarioService");
        UsuarioDto usuarioDto =  userService.getUser(username);

        response.addHeader("UserId", usuarioDto.getUserId());
        response.addHeader(SecurityConstans.HEADER_STRING, SecurityConstans.TOKEN_PREFIX + token);        

    }

}
