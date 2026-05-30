package com.buensabor.coffeemanagement.tables.repository;

import com.buensabor.coffeemanagement.tables.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablesRepository extends JpaRepository<Tables, Long> {
}