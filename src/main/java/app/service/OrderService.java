package app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.Order;
import app.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public ArrayList<Order> getAll(){
		return (ArrayList<Order>) orderRepository.findAll();
	}
	
	public Order save (Order order) {
		return orderRepository.save(order);
	}
	
	public Optional<Order> getById (Integer id){
		return orderRepository.findById(id);
	}
	
	public boolean delete (Integer id) {
		try {
			orderRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
