package com.bah.msd.mcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bah.msd.mcc.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByName(String name); 
	
	public void deleteByName(String name);
		
	
}


