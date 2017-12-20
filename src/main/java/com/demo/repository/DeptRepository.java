package com.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Department;

public interface DeptRepository extends JpaRepository<Department, Serializable>{
}
