package com.tienda.service.TiendaBackend.controllers;

import com.tienda.service.TiendaBackend.entities.Product;
import com.tienda.service.TiendaBackend.repositories.ProductRepository;
import com.tienda.service.TiendaBackend.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("tienda")

public class ProductController {

    private final ProductRepository productRepo;
    private final ProductServices productService;

    public ProductController(ProductRepository productRepo, ProductServices productService) {
        this.productRepo = productRepo;
        this.productService = productService;
    }

    // OBTENER TODOS LOS PRODUCTOS
    @GetMapping("/products")
    public List<Product> getAll(){
    return productRepo.findAll();
    }

    //REGISTRO DE PRODUCTO
    @PostMapping("/user/{userId}/register")
    public ResponseEntity<?> register(@PathVariable Long userId, @RequestBody Product productX){
        Product createProduct = productService.createProduct(userId,productX);
        if (createProduct != null){
            return ResponseEntity.ok(createProduct);
        }
        return ResponseEntity.status(403).body("Usuario sin permisos");
    }

    // ACTUALIZAR STOCK DE UN PRODUCTO
    @PatchMapping("/user/{userId}/product/{productId}/stock")
    public ResponseEntity<?> updateStock(@PathVariable Long userId,@PathVariable Long productId, @RequestBody Product productFromFront){
       Product verificationStock = productService.stockVerificacion(userId, productId, productFromFront);
       if (verificationStock != null){
           return ResponseEntity.ok(verificationStock);
       }
       return ResponseEntity.status(403).body("Usuario sin permisos");
    }

    @DeleteMapping("/user/{userId}/product/{productId}/delete")
    public ResponseEntity<?> deleteProduct(@PathVariable Long userId,@PathVariable Long productId){
      boolean deleteProduct = productService.deleteProduct(userId,productId);
      if(deleteProduct){
          return ResponseEntity.ok().body("Producto Eliminado");
      }
      return ResponseEntity.status(403).body("Usuario sin permisos");
    }

}
