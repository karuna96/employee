package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.employeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<employeeEntity, Long> {

}
