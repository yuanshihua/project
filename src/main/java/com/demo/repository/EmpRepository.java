package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Employee;

public interface EmpRepository extends JpaRepository<Employee, Serializable>{

}
