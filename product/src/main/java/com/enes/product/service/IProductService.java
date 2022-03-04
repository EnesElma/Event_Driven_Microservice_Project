package com.enes.product.service;

import com.enes.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {


    Product saveOrUpdateProduct(Product product);

    Optional<Product> details(Long id);

    List<Product> listAllProduct();

    void deleteProduct(Long id);

    boolean productValidate(Long id, int quantity);
}
