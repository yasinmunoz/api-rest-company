package app.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Customer;
import app.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping()
	public ArrayList<Customer> getCustomers(){
		return customerService.getAll();
	}
	
	@PostMapping()
	public Customer saveCustomer (@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@GetMapping(path="/id/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Integer id){
		return customerService.getById(id);
	}
	
	@DeleteMapping(path="/id/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer id) {
		
		boolean ok = customerService.delete(id);
		
		if (ok) {
			return "The customer with id " + id + " was successfully deleted.";
		} else {
			return "The customer with id " + id + " could not be deleted.";
		}
	}
}
