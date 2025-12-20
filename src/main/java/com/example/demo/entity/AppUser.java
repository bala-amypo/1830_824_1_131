// package com.example.demo.entity;

// import jakarta.persistence.*;

// import java.util.Set;

// @Entity
// @Table(
//     name = "app_users",
//     uniqueConstraints = @UniqueConstraint(columnNames = "email")
// )
// public class AppUser {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String email;

//     private String password;

//     @ElementCollection(fetch = FetchType.EAGER)
//     @CollectionTable(name = "user_roles")
//     private Set<String> roles;

//     private Boolean active = true;

//     // getters & setters
// }
