package com.tienda.service.TiendaBackend.repositories;

import com.tienda.service.TiendaBackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long> {

}
