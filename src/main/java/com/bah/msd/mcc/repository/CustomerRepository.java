package com.bah.msd.mcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.msd.mcc.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

		public Customer findByName(String name);
}


