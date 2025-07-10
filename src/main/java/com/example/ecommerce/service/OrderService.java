package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class OrderService {

  private final OrderRepository repo;

  public OrderService(OrderRepository repo) {
    this.repo = repo;
  }

  public Order create(Order o) {
    return repo.save(o);
  }

  public List<Order> findAll() {
    return repo.findAll();
  }

  public Optional<Order> findById(Long id) {
    return repo.findById(id);
  }

  public Order update(Long id, Order updated) {
    return repo.findById(id)
      .map(o -> {
        o.setProduct(updated.getProduct());
        o.setUser(updated.getUser());
        o.setQuantity(updated.getQuantity());
        return repo.save(o);
      })
      .orElseThrow(() -> new EntityNotFoundException("Order not found"));
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }
}
