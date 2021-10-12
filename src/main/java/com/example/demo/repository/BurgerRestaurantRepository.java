package com.example.demo.repository;

import com.example.demo.domain.BurgerRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BurgerRestaurantRepository extends JpaRepository<BurgerRestaurant, String> {
}
