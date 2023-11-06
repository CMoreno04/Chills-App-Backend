package com.chillsrestaurant.app.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Customer extends User {
    private String username;

    @Override
    public String getUsername() {
        return this.username;
    }
}
