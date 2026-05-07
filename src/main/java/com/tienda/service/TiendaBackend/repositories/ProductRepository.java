package com.tienda.service.TiendaBackend.repositories;


import com.tienda.service.TiendaBackend.entities.Product;
import com.tienda.service.TiendaBackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product,Long>{
    Optional<Product> findById(Long id);
}
