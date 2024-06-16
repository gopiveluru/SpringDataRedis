package com.example.SpringDataRedis.repository;

import com.example.SpringDataRedis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate template;

    public static final String PRODUCT_KEY = "Product";


    public Product save(Product product)
    {
        template.opsForHash().put(PRODUCT_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll()
    {
        return template.opsForHash().values(PRODUCT_KEY);
    }

    public Product findProductById(int id)
    {
        return (Product) template.opsForHash().get(PRODUCT_KEY,id);
    }

    public String deleteProduct(int id)
    {
        template.opsForHash().delete(PRODUCT_KEY,id);
        return "Deleted successfully!!!";
    }
}
