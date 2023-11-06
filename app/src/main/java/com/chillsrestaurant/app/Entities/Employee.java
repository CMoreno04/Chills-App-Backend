package com.chillsrestaurant.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "employee")
public class Employee extends User {
    private String employeeId;

    public Integer getId(){
        return super.id;
    }

    public String getEmail(){
        return super.email;
    }
}
