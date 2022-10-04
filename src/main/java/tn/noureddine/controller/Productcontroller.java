package tn.noureddine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.noureddine.exception.RessourceNotFoundException;
import tn.noureddine.model.Product;
import tn.noureddine.repository.ProductRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class Productcontroller {

	@Autowired
	private ProductRepository pr;

	// get all Product
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return pr.findAll();

	}
/*
	// add product
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {

		return pr.save(product);

	}

	// get product by id rest api
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = pr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Product not exist with id :" + id));
		return ResponseEntity.ok(product);
	}
	// update employee by id
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateproductbyId(@PathVariable Long id, @RequestBody Product pdetails) {

		Product product = pr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Product not exist with id :" + id));
		product.setCategory(pdetails.getCategory()); 
		product.setAvailable(pdetails.isAvailable());
		product.setCurrentPrice(pdetails.getCurrentPrice());
		product.setName(pdetails.getName());
		product.setDescription(pdetails.getDescription());
		product.setPhotoName(pdetails.getPhotoName());
		product.setPromotion(pdetails.isPromotion());
		product.setSelected(pdetails.isSelected());
		Product updatedproduct = pr.save(product);

		return ResponseEntity.ok(updatedproduct);

	}
	// delete employee rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){

		Product product = pr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Product not exist with id :" + id));

		pr.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
*/
}
