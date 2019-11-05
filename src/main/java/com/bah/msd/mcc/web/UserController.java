package com.bah.msd.mcc.web;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

//import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bah.msd.mcc.domain.User;
import com.bah.msd.mcc.repository.InMemoryRepository;
import com.bah.msd.mcc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	private InMemoryRepository repo = new InMemoryRepository();
	
	@GetMapping("/")
	public Collection<User> ListUsers() {
		Collection<User> users=Collections.unmodifiableCollection(this.repo.listAllUsers());
		return users;
		
		
	}
	
	@GetMapping("/browse")
	public ModelAndView browseUsers() {
		Iterable<User> list = userService.findAllUsers();
		
		return new ModelAndView("browseUsers", "userList", list);
	}

}
