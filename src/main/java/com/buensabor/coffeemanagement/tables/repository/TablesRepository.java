package com.buensabor.coffeemanagement.tables.repository;

import com.buensabor.coffeemanagement.tables.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {
    Optional<Tables> findByNumber(Integer number);
}