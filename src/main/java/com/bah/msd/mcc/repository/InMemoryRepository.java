package com.bah.msd.mcc.repository;

import java.util.ArrayList;
import java.util.List;

import com.bah.msd.mcc.domain.User;



public class InMemoryRepository {
	
	private List<User> users = new ArrayList<>();
	
	public InMemoryRepository() {
		// TODO Auto-generated constructor stub
	
		this.createUser();
	}
	
	public void createUser() {
		users.add(new User("Hasan", "2313243", "hasan.tennis@gmail.com"));
		users.add(new User("Hasan", "2313243", "hasan.tennis@gmail.com"));
		users.add(new User("Hasan", "2313243", "hasan.tennis@gmail.com"));
	}
	
	public List<User> listAllUsers() {
		return this.users;
	}
	
	
}
