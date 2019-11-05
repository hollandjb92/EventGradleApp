package com.bah.msd.mcc.service;

import java.util.Optional;

import com.bah.msd.mcc.domain.User;

public interface UserService {
	
	
	public void saveUser(User user);

	public Iterable<User> findAllUsers();

	public Optional<User> findUserById(long id);

}
