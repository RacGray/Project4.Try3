package org.example.service;

import org.example.entity.Product;
import org.example.entity.Seller;
import org.example.repository.ProductRepository;
import org.example.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    ProductRepository productRepository;
    SellerRepository sellerRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository)
    {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Product saveProduct(long id, Product p) throws Exception
    {
        Optional<Seller> optional = sellerRepository.findById(id);
        Seller s;
        if(optional.isEmpty())
        {
            throw new Exception("no such seller...");
        }
        else
        {
            s = optional.get();
        }
        Product savedProduct = productRepository.save(p);
        s.getProducts().add(savedProduct);
        sellerRepository.save(s);
        return savedProduct;
    }

}
