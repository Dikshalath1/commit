package com.project.Infycart.product.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.project.Infycart.product.dto.SubscribedproductDTO;
import com.project.Infycart.product.entity.Subscribedproduct;
import com.project.Infycart.product.repository.SubscribedproductRepository;

@Service
public class SubscribedproductService {
	@Autowired
	SubscribedproductRepository subscribedproductRepository;
	
	@Autowired
	Environment environment;
	
	public void addProduct(SubscribedproductDTO subscribedProductDTO) throws Exception{
		Subscribedproduct sub = subscribedProductDTO.createEntity();
		subscribedproductRepository.save(sub);
	}
	
	
	public List<SubscribedproductDTO> getSubscribedProducts(int buyerId) throws Exception{
		List<Subscribedproduct> subscribedProducts = subscribedproductRepository.findByBuyerId(buyerId);
		List<SubscribedproductDTO> subscribedProductDTOs = new ArrayList<>();
		if(subscribedProducts.isEmpty()) {
			throw new Exception("Service.NO_SUBSCRIBED_PRODUCT_FOUND");
		}else {
			for(Subscribedproduct subscribedProduct : subscribedProducts ) {
				SubscribedproductDTO subscribedProductDTO = SubscribedproductDTO.valueOf(subscribedProduct);
				subscribedProductDTOs.add(subscribedProductDTO);
			}
		return subscribedProductDTOs;
		}
	}
}

