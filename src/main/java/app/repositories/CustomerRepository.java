package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
