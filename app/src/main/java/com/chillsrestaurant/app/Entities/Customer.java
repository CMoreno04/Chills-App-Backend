package com.chillsrestaurant.app.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "customer")
public class Customer extends User {

    private String username;

    // Manually provide the getUsername method
    @Override
    public String getUsername() {
        return this.username;
    }

    // Implement equals and hashCode based on the id and username, which should be
    // unique for each Customer
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        if (!super.equals(o))
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(username, customer.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username);
    }

    // Implement toString method to prevent recursion or large data inclusion
    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                '}';
    }
}
