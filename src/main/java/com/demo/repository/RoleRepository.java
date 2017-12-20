package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>{

}
