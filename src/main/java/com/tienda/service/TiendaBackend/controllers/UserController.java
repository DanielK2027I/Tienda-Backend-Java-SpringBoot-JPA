package com.tienda.service.TiendaBackend.controllers;
import com.tienda.service.TiendaBackend.entities.Users;
import com.tienda.service.TiendaBackend.repositories.UserRepository;
import com.tienda.service.TiendaBackend.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;
    private final UserServices userServices;

    public UserController(UserRepository userRepository, UserServices userServices) {
        this.userRepository = userRepository;
        this.userServices = userServices;

    }

     // MOSTRAR TODOS
    @GetMapping("/showUser")
    public List<Users> showUser(){
        return userRepository.findAll();
    }

    // CREAR CUENTA
    @PostMapping("/register")
    public Users register(@RequestBody Users userX){
        return userServices.registerVerificacion(userX);
    }

    // LOGIN DE USUARIO
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users userX) {
        Users valid = userServices.loginUser(userX);
        if (valid != null) {
            return ResponseEntity.ok(valid);
        }
        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }

}
