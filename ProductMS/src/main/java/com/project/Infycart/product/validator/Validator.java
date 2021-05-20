package com.project.Infycart.product.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.project.Infycart.product.dto.ProductDTO;

@Component
public class Validator {
	
	@Autowired
	Environment environment;
	

	public void validateProduct(ProductDTO product) throws Exception {
		if(!validateName(product.getProductname())) {
			throw new Exception(environment.getProperty("INVALID_NAME"));
		}
		if(!validateDescription(product.getDescription())){
			throw new Exception(environment.getProperty("INVALID_DESCRIPTION"));
		}
		if(!validatePrice(product.getPrice())) {
			throw new Exception(environment.getProperty("INVALID_PRICE"));
		}
		if(!validateStock(product.getStock())) {
			throw new Exception(environment.getProperty("INVALID_STOCK"));
		}
		if(!validateImage(product.getImage())) {
			throw new Exception(environment.getProperty("INVALID_IMAGE"));
		}
   }

	public static boolean validateImage(String image) {
		
		String regex="([http://]+[^\\s]+(\\.(?i)(jpeg|png))$)";
		if(image.matches(regex)) {
			
		
			return true;
		}
		return false;
	}

	private static boolean validateStock(int stock) {
	  if(stock>=10)
		return true;
	  else
		return false;
	}

	private static boolean validatePrice(double price) {
		if(price>=200.0)
			return true;
		  else
			return false;
	}


	private static boolean validateDescription(String description) {
	    if(description.length()<=500)
		    return true;
	    else
	    	return false;
	}


	private static boolean validateName(String productname) {
		String regex="([A-Za-z]+\\s?)+[^@#$%^&*_!0-9. ]";
		 if(productname.matches(regex) && productname.length()<=100){
	            return true;
	        }
		 else
			   return false;
	}
	
	
}
