package com.chillsrestaurant.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chillsrestaurant.app.entities.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);

     @Query("SELECT c.email FROM Customer c WHERE c.username = :username")
    Optional<String> findEmailByUsername(@Param("username") String username);

}