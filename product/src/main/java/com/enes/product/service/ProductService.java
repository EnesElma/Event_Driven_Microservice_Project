package com.enes.product.service;

import com.enes.product.entity.Product;
import com.enes.product.repo.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveOrUpdateProduct(Product product){
        //if name is null
        if (product.getId() != 0 && product.getName() == null){
            Product product1=repository.findById(product.getId()).orElse(null);
            product.setName(product1.getName());
        }
        //if stock is null
        if (product.getId() != 0 && product.getStock() == 0){
            Product product1=repository.findById(product.getId()).orElse(null);
            product.setStock(product1.getStock());
        }
        return repository.save(product);
    }

    @Override
    public Optional<Product> details(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Product> listAllProduct(){
        return repository.findAll();
    }

    @Override
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    @Override
    public boolean productValidate(Long id, int quantity){
        Product product = repository.findById(id).orElse(null);

        if (product != null && product.getName() != null && product.getStock() > 0 && product.getStock() >= quantity){
            product.setStock(product.getStock() - quantity);
            repository.save(product);
            return true;
        }
        else {
            return false;
        }
    }
}
