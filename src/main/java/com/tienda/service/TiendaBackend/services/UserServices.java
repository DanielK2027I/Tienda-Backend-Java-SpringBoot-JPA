package com.tienda.service.TiendaBackend.services;
import com.tienda.service.TiendaBackend.config.SecurityConfig;
import com.tienda.service.TiendaBackend.entities.Users;
import com.tienda.service.TiendaBackend.repositories.RoleRepository;
import com.tienda.service.TiendaBackend.repositories.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;


    // VERIFICACION DE ASIGNACION DE ROL Y HASH A USUARIO
    public Users registerVerificacion(Users user){
        String nameUser = user.getRolename();
        //obtener password del user del front
        String passwordUser = user.getPassword();
        // crear variable para usar la funcion generate y metemos el password del user front
        String hash = generateHash(user.getPassword());
        // seteamos el hash resultante en el passwotd del user front
        user.setPassword(hash);
        if(nameUser.equals("ADMIN") ){
            user.setRole(roleRepository.findById(1L).get());
        }else{
            user.setRole(roleRepository.findById(2L).get());
        }
        return usuarioRepository.save(user);
    }

    // CREACION DE HASH EN CONTRASEÑA
    private String generateHash(String password){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1,1024*1,1,password);
    }

    // VERIFICACION DE CUENTA DE INICIO DE SESION
    public Users loginUser(Users user){
        String username = user.getUsername();
        String password = user.getPassword();
        Optional<Users> nameRepository = usuarioRepository.findByUsername(user.getUsername());
        if (nameRepository.isPresent()) {
            Users userDB = nameRepository.get();
            if (userDB.getUsername().equals(username) && passwordEncoder.matches(password,userDB.getPassword())){
                return userDB;
            }
        }
        return  null;
    }

}
