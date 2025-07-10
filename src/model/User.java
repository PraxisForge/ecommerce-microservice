package com.example.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Email
  @NotBlank
  @Column(nullable = false, unique = true)
  private String email;

  @NotBlank
  @Column(nullable = false)
  private String password;

  // Simple roles as comma-separated; or use a join table for ManyToMany
  @NotBlank
  private String roles;

  // Bidirectional: one user can have many orders
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Order> orders;

  public User() { }

  // Getters & setters...
}
