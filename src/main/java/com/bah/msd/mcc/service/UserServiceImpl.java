package com.bah.msd.mcc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.mcc.domain.User;
import com.bah.msd.mcc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	public void saveUser(User user) {
		User user1 = new User("Hasan", "234325" ,"h1syed@gmail.com");
		User user2 = new User("Jordan", "password", "hollandjb@vcu.edu");
				
		repo.save(user1);
		repo.save(user2);
	}

	public Iterable<User> findAllUsers() {
		return repo.findAll();
	}

	public Optional<User> findUserById(long id) {
		return repo.findById(id);
	}

}
