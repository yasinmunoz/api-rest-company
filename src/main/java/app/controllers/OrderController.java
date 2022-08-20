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

import app.models.Order;
import app.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping()
	public ArrayList<Order> getOrders () {
		return orderService.getAll();
	}
	
	@PostMapping() 
	public Order saveOrder (@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@GetMapping(path="/id/{id}")
	public Optional<Order> getOrderById(@PathVariable("id") Integer id) {
		return orderService.getById(id);
	}
	
	@DeleteMapping(path = "/id/{id}")
	public String deleteOrderById(@PathVariable("id") Integer id) {
		
		boolean ok = orderService.delete(id);
		
		if (ok) {
			return "The order with id " + id + " was successfully deleted.";
		} else {
			return "The customer with id " + id + " could not be deleted.";
		}
	}
	
}
