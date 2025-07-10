package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProductService {
  private final ProductRepository repo;

  public ProductService(ProductRepository repo) {
    this.repo = repo;
  }

  public Product create(Product p) {
    return repo.save(p);
  }

  public List<Product> findAll() {
    return repo.findAll();
  }

  public Optional<Product> findById(Long id) {
    return repo.findById(id);
  }

  public Product update(Long id, Product updated) {
    return repo.findById(id)
      .map(p -> {
        p.setName(updated.getName());
        p.setPrice(updated.getPrice());
        p.setDescription(updated.getDescription());
        return repo.save(p);
      })
      .orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }
}
