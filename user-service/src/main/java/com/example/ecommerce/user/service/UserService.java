package com.example.ecommerce.user.service;

import com.example.ecommerce.user.model.User;
import com.example.ecommerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
@Transactional
public class UserService {
  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public User create(User u) {
    return repo.save(u);
  }

  public List<User> findAll() {
    return repo.findAll();
  }

  @CircuitBreaker(name = "default", fallbackMethod = "findByIdFallback")
  @Retry(name = "default")
  public Optional<User> findById(Long id) {
    return repo.findById(id);
  }

  public Optional<User> findByIdFallback(Long id, Throwable t) {
    return Optional.empty();
  }

  public User update(Long id, User updated) {
    return repo.findById(id)
      .map(u -> {
        u.setEmail(updated.getEmail());
        u.setPassword(updated.getPassword());
        u.setRoles(updated.getRoles());
        return repo.save(u);
      })
      .orElseThrow(() -> new EntityNotFoundException("User not found"));
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }
}
