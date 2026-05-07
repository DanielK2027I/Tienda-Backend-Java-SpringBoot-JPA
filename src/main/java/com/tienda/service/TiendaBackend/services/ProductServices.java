package com.tienda.service.TiendaBackend.services;
import com.tienda.service.TiendaBackend.entities.Product;
import com.tienda.service.TiendaBackend.entities.Users;
import com.tienda.service.TiendaBackend.repositories.ProductRepository;
import com.tienda.service.TiendaBackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    private final ProductRepository productRepo;
    private final UserRepository userRepository;

    public ProductServices(ProductRepository productRepo,UserRepository userRepository) {
        this.productRepo = productRepo;
        this.userRepository = userRepository;
    }

    // FUNCION PARA VERIFICAR STOCK SEGUN PERMISOS
    public Product stockVerificacion(Long userId, Long productId, Product productFromFront) {
      Optional<Product> productFound = productRepo.findById(productId);
        Product productDB = productFound.get();
        List permissions = getPermissions(userId);

      if (permissions.contains("COMPRAR_PRODUCTO")){
         Integer stockRest = productFromFront.getStock();
         Integer stockProductDB = productDB.getStock();
         productDB.setStock(stockProductDB - stockRest);
         return productRepo.save(productDB);
      }
      return null;
    }

    // FUNCION PARA ELIMINAR PRODUCTO SEGUN PERMISOS
    public boolean deleteProduct(Long userId, Long productId){
        Optional<Product> productFound = productRepo.findById(productId);
        List permissions = getPermissions(userId);
        if (permissions.contains("BORRAR_PRODUCTO")){
            productRepo.delete(productFound.get());
            return true;
        }
        return false;
    }
    // FUNCION PARA CREAR PRODUCTO SEGUN PERMISOS
    public Product createProduct(Long userId, Product productx){
        List permissions = getPermissions(userId);
        if (permissions.contains("CREAR_PRODUCTO")){
            return productRepo.save(productx);
        }
        return null;
    }

    // FUNCION PARA OBTENER PERMISOS DE UN USUARIO
    private List getPermissions (Long userId){
        Optional<Users> usersFound = userRepository.findById(userId);
        if (usersFound.isPresent()){
            Users userDB = usersFound.get();
            List <String> permissions = userDB.getRole().getPermissions();
            return  permissions;
        }
        return Collections.EMPTY_LIST;
    }
}

