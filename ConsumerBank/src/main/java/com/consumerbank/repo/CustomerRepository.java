package com.consumerbank.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consumerbank.dto.CustomerResponse;
import com.consumerbank.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	CustomerResponse findCustomerBycustomerId(Integer customerId);
	
}
