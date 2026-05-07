package com.tienda.service.TiendaBackend;
import com.tienda.service.TiendaBackend.entities.Users;
import com.tienda.service.TiendaBackend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TiendaBackendApplicationTests {
    @Autowired
    private UserRepository userRepository;


    @Test
	void getPermissions() {
        Optional<Users> usersFound = userRepository.findById(4L);
        if (usersFound.isPresent()){
            Users userDB = usersFound.get();
            List <String> permissions = userDB.getRole().getPermissions();
            System.out.println(permissions);
        }
	}
}
