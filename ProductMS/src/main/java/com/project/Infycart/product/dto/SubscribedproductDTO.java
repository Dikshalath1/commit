package com.project.Infycart.product.dto;


import com.project.Infycart.product.entity.Subscribedproduct;

public class SubscribedproductDTO {
	int buyerid;
	int prodid;
	int quantity;
	
	
	public SubscribedproductDTO() {
		super();
	}
	
	public SubscribedproductDTO( int buyerid, int prodid, int quantity) {
		super();
		this.buyerid = buyerid;
		this.prodid = prodid;
		this.quantity = quantity;
	}

	
	

	public int getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
		public static SubscribedproductDTO valueOf(Subscribedproduct subscribedproduct) {
			SubscribedproductDTO subscribedproductDTO = new SubscribedproductDTO();
			subscribedproductDTO.setBuyerid(subscribedproduct.getBuyerid());
			subscribedproductDTO.setProdid(subscribedproduct.getProdid());
			subscribedproductDTO.setQuantity(subscribedproduct.getQuantity());
			return subscribedproductDTO;
		}
		
		
		public Subscribedproduct createEntity() {
			Subscribedproduct subscribedproduct = new Subscribedproduct();
			subscribedproduct.setBuyerid(this.getBuyerid());
			subscribedproduct.setProdid(this.getProdid());
			subscribedproduct.setQuantity(this.getQuantity());
			return subscribedproduct;
		}

		@Override
		public String toString() {
			return "SubscribedproductDTO [ buyerid=" + buyerid + ", prodid=" + prodid
					+ ", quantity=" + quantity + "]";
		}
	
}	