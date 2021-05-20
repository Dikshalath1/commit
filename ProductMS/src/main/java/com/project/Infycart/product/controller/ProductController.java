package com.project.Infycart.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.Infycart.product.dto.ProductDTO;
import com.project.Infycart.product.dto.SubscribedproductDTO;
import com.project.Infycart.product.service.ProductService;
import com.project.Infycart.product.service.SubscribedproductService;

@RestController
@CrossOrigin
public class ProductController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	@Autowired
	SubscribedproductService subscribedproductService; 
	

	@Autowired
	Environment environment;
	
	// Fetches all products
	@GetMapping(value = "/api/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getAllProducts() throws Exception{
		logger.info("Fetching all products");
		System.out.println("In controller");
		return productService.getAllProducts();
	}
	
	// Fetches products by category
	@GetMapping(value = "/api/{category}/products",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByCategory(@PathVariable String category) throws Exception{
		logger.info("Product details for category {}", category);
		return productService.getProductByCategory(category);
	}
	
	// Fetches products by product name
	@GetMapping(value = "/api/product/{productname}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getProductsByName(@PathVariable String productname) throws Exception{
		logger.info("Product details for product name {}", productname);
		return productService.getProductByName(productname);
	}
	
	// Fetches products by product id
		@GetMapping(value = "/api/productid/{prodId}")
		public ProductDTO getProductsById(@PathVariable Integer prodId) throws Exception{
			logger.info("Product details for product with prodid {}", prodId);
			return productService.getProdByProdId(prodId);
		}
		
		
		// add a product
		@PostMapping(value = "/api/product/add")
		public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO)
		{
			logger.info("Add request for product {}",productDTO);
			ResponseEntity<String>response;
			String successMessage = "Product added successfully !!!!!!!";
			String errorMessage = "Duplicate entry found !!!!!!!";
			try
			{
				productService.addProduct(productDTO);
				response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
			}catch(Exception e) {
				response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return response;
		}
		
		// remove product by product id
		@DeleteMapping(value = "/api/product/{prodid}/remove")
		public ResponseEntity<String> removeProduct(@PathVariable Integer prodid)
		{
			logger.info("Remove request for product with productid {}",prodid);
			ResponseEntity<String>response;
			String successMessage = "Product removed successfully !!!!!!!";
			String errorMessage = "No such product found";
			if(productService.removeProduct(prodid)) {
				response = new ResponseEntity<String>(successMessage, HttpStatus.OK);
			}else {
				response = new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
			}
			return response;
		}
		
		// add product to subscription
		@PostMapping(value = "/api/subscriptions/add", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> addProductToSubscription(@RequestBody SubscribedproductDTO subscribedProductDTO) throws Exception{
			logger.info("Add to subscription request for product {} ", subscribedProductDTO);
			ResponseEntity<String> response = null;
			try {
				subscribedproductService.addProduct(subscribedProductDTO);
				String success_message = "Product added to subscription successfully";
				response = new ResponseEntity<String>(success_message,HttpStatus.CREATED);
			}catch(Exception e){
				response = new ResponseEntity<String>(environment.getProperty(e.getMessage()),HttpStatus.BAD_REQUEST);
			}
			return response;			
		}
		
		// Get the Subscribed Product By BuyerId
		@GetMapping(value="/api/subscriptions/{buyerid}")
		public ResponseEntity<List<SubscribedproductDTO>> getSubscribedProductByBuyerId(@PathVariable Integer buyerid)
		{
			logger.info("Fetching product by Buyer Id {}", buyerid);
			ResponseEntity<List<SubscribedproductDTO>> response = null;
			try {
				List<SubscribedproductDTO> subscribedProducts = subscribedproductService.getSubscribedProducts(buyerid);
				response = new ResponseEntity<List<SubscribedproductDTO>>(subscribedProducts,HttpStatus.OK);
			}catch(Exception e){
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
			}
			return response;
		}
		
		//Update stock
		@PutMapping(value="/api/product/updatestock")
		public ResponseEntity<String> updateStock(@RequestBody ProductDTO productDTO)
		{
			logger.info("update product for {}",productDTO);
			ResponseEntity<String>response;
			String successMessage = "Product stock updated successfully !!!!!!!";
			String errorMessage = "No such product found";
			try {
				productService.updateStock(productDTO);
				response = new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
			}catch(Exception e) {
				response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return response;
		}
}