package com.enes.product.controller;

import com.enes.product.entity.Product;
import com.enes.product.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping("saveOrUpdate")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdateProduct(product));
        }catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.CONFLICT).body("duplicate key value violates or null value");
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> productDetails(@PathVariable Long id){
        return ResponseEntity.ok(service.details(id));
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(service.listAllProduct());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok("Ürün başarıyla silindi");
    }

    /**
     * Sipariş oluştururken ürünün var olup olmadığını ve stoğunun yeterliliğini kontrol eden metod
     * Eğer true dönerse stoktan quantity kadar düşülür
     * @param json
     * @return
     */
    @PostMapping("validate")
    public boolean productValidate(@RequestBody Map<String, String> json){
        long id = Long.parseLong(json.get("id"));
        int quantity= Integer.parseInt(json.get("quantity"));
        return service.productValidate(id,quantity);
    }
}














