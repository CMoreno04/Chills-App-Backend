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
@Table(name = "employee")
public class Employee extends User {

    private String employeeId;

    public Integer getId(){
        return id;
    }
   // We override the toString method to prevent potential StackOverflowError
   @Override
   public String toString() {
       return "Employee{" +
              ", employeeId='" + employeeId + '\'' +
              '}';
   }

   // Override equals and use only the id for comparison to prevent StackOverflowError
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       if (!super.equals(o)) return false;
       Employee employee = (Employee) o;
       return Objects.equals(employeeId, employee.employeeId);
   }

   // Override hashCode and use only the id for the hashcode to prevent StackOverflowError
   @Override
   public int hashCode() {
       return Objects.hash(super.hashCode(), employeeId);
   }
}
