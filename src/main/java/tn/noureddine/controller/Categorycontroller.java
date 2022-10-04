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
import tn.noureddine.model.Category;
import tn.noureddine.repository.CategoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class Categorycontroller {
	@Autowired
	private CategoryRepository cr;

	public void setCr(CategoryRepository cr) {
		this.cr = cr;
	}

	// get all Category
	@GetMapping("/categories")
	public List<Category> getAllCategory() {
		return cr.findAll();

	}

	// add Category
	@PostMapping("/categories")
	public Category createCategory(@RequestBody Category cat) {

		return cr.save(cat);

	}

	// get Category by id rest api
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoriesById(@PathVariable Long id) {
		Category cat = cr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Category not exist with id :" + id));
		return ResponseEntity.ok(cat);
	}

	// update Category by id
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updatecatebyId(@PathVariable Long id, @RequestBody Category catdetais) {

		Category cat = cr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Category not exist with id :" + id));
		cat.setDescription(catdetais.getDescription());
		cat.setName(catdetais.getName());
		cat.setProducts(catdetais.getProducts());
		Category updatedcat = cr.save(cat);

		return ResponseEntity.ok(updatedcat);

	}

	// delete Category rest api
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Map<String, Boolean>> deletecategoy(@PathVariable Long id) {

		Category cat = cr.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Category not exist with id :" + id));

		cr.delete(cat);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
