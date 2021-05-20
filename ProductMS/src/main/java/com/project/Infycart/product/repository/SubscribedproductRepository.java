package com.project.Infycart.product.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Infycart.product.entity.Subscribedproduct;

public interface SubscribedproductRepository extends JpaRepository<Subscribedproduct, Integer>{
	public List<Subscribedproduct> findByBuyerId(int buyerId);
}
