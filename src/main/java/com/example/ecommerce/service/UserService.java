package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;

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

  public Optional<User> findById(Long id) {
    return repo.findById(id);
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