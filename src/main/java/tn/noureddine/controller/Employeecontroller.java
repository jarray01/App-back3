package tn.noureddine.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
import tn.noureddine.model.Employee;
import tn.noureddine.repository.EmployeeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class Employeecontroller {

	@Autowired
	private EmployeeRepository employeerepository;

	// get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();

	}
	// add employee
	@PostMapping("/employees")
	public Employee createEmploye(@RequestBody Employee employee) {
		
		return employeerepository.save(employee);
		
	}
	// get employee by id rest api
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee employee = employeerepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(employee);
		}
		
	//update employee by id
		@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateemployeebyId(@PathVariable Long id, @RequestBody Employee employeedetails){
		
			Employee employee = employeerepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
			employee.setFirstname(employeedetails.getFirstname());
			employee.setLastname(employeedetails.getLastname());
			employee.setEmailId(employeedetails.getEmailId());
			Employee updatedemployee = employeerepository.save(employee);
			
			return ResponseEntity.ok(updatedemployee);
	
			
	}
		// delete employee rest api
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){

			Employee employee = employeerepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Employee not exist with id :" + id));
	
			employeerepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
