package com.bah.msd.mcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.msd.mcc.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByName(String name); 
	
	public void deleteByName(String name);
		
}


