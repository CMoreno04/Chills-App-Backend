package com.chillsrestaurant.app.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chillsrestaurant.app.Entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByEmployeeId(String string);
    
    @Query("SELECT e.email FROM Employee e WHERE e.employeeId = :employeeId")
    Optional<String> findEmailByEmployeeId(@Param("employeeId") String employeeId);

}