package com.buensabor.coffeemanagement.supply.repository;

import com.buensabor.coffeemanagement.supply.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    
}