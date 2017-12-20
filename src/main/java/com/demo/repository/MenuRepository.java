package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Serializable>{
	
}
