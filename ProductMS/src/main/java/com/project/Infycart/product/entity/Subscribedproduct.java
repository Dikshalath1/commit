package com.project.Infycart.product.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.Infycart.product.dto.ProductDTO;

@Entity
@Table(name = "subscribedproduct")
public class Subscribedproduct {
	@Id
	@Column(nullable = false)
	int buyerId;
	@Column(nullable = false)
	int prodId;
	@Column(nullable = false)
	int quantity;
	
	
	public Subscribedproduct() {
		super();
	}
	
	public Subscribedproduct(int buyerId, int prodId, int quantity) {
		super();
		
		this.buyerId = buyerId;
		this.prodId = prodId;
		this.quantity = quantity;
	}

	
	

	public int getBuyerid() {
		return buyerId;
	}

	public void setBuyerid(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getProdid() {
		return prodId;
	}

	public void setProdid(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}