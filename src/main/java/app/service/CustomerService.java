package app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Customer;
import app.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public ArrayList<Customer> getAll(){
		return (ArrayList<Customer>) customerRepository.findAll();
	}
	
	public Customer save (Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getById (Integer id){
		return customerRepository.findById(id);
	}
	
	public boolean delete (Integer id) {
		try {
			customerRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
}
