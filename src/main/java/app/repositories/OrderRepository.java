package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
