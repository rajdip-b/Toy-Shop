package com.app.toyshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.toyshop.entity.Toy;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {

}
