package com.example.onetomanytest.service;

import com.example.onetomanytest.domain.Category;
import com.example.onetomanytest.domain.Product;
import com.example.onetomanytest.repository.CategoryRepository;
import com.example.onetomanytest.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IDatabaseImpl implements IDatabase {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public IDatabaseImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void createDatabase() {
        Category c1=new Category();
        c1.setName("Fruits");

        Category c2=new Category();
        c2.setName("Meats");

        Product p1=new Product("Apple",25,2000);
        Product p2=new Product("Orange",28,1000);
        Product p3=new Product("Pork",27,80000);
        Product p4=new Product("Chicken",85,3000);

        c1.getProducts().add(p1);
        c1.getProducts().add(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);


        categoryRepository.save(c1);
        categoryRepository.save(c2);
//
//        productRepository.save(p1);
//        productRepository.save(p2);
//        productRepository.save(p3);
//        productRepository.save(p4);
    }
}
