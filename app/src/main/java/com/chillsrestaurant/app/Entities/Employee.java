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
public class Employee extends User {
    private String employeeId;

    public Integer getId(){
        return super.id;
    }

    public String getEmail(){
        return super.email;
    }
}
