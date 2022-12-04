package com.multiristorante.app.backend.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.multiristorante.app.backend.Entities.Usuario;
import com.multiristorante.app.backend.Shared.dto.UsuarioDto;
import com.multiristorante.app.backend.exceptions.EmailExistsException;
import com.multiristorante.app.backend.repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioServiceInterface{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuarioDto) {

        if (usuarioRepository.findByEmail(usuarioDto.getEmail()) != null) {
            throw new EmailExistsException("El correo electronico ya esta en uso");
        } 

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        usuario.setEncryptedPassword(
            bCryptPasswordEncoder.encode(usuarioDto.getPassword())
        );

        UUID userid = UUID.randomUUID();
        usuario.setUserId(userid.toString());

        Usuario storeUserDetails = usuarioRepository.save(usuario);

        UsuarioDto userToReturn = new UsuarioDto();
        BeanUtils.copyProperties(storeUserDetails, userToReturn);

        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario == null){
            throw new UsernameNotFoundException(email);
        }

        return new User(usuario.getEmail(),usuario.getEncryptedPassword(), new ArrayList<>());
    }

    @Override
    public UsuarioDto getUser(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if(usuario == null){
            throw new UsernameNotFoundException(email);
        }
        UsuarioDto userToReturn = new UsuarioDto();
        BeanUtils.copyProperties(usuario, userToReturn);
        return userToReturn;
    }
}
