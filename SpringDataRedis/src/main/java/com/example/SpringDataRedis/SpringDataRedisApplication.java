package com.example.SpringDataRedis;

import com.example.SpringDataRedis.entity.Product;
import com.example.SpringDataRedis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisApplication {

	@Autowired
	ProductDao dao;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

	@PostMapping
	public Product save(@RequestBody Product product)
	{
		return dao.save(product);
	}

	@GetMapping
	public List<Product> findAll()
	{
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id)
	{
		return dao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		return dao.deleteProduct(id);
	}
}
