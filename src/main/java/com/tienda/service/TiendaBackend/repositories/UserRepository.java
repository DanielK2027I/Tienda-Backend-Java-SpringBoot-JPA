package com.tienda.service.TiendaBackend.repositories;
import com.tienda.service.TiendaBackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findById(Long userID);

}
