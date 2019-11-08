package com.bah.msd.mcc.web;

import java.util.Optional;

//import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bah.msd.mcc.domain.User;
import com.bah.msd.mcc.repository.UserRepository;
import com.bah.msd.mcc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repo;

	
	@GetMapping("/all")
	public Iterable<User> getAll(){
		return repo.findAll();
	}
	
//	@GetMapping("/{userId}")
//	public Optional<User> getUserById(@PathVariable("userId") long id){
//		return repo.findById(id);
//	}
	
	@GetMapping("/{userName}")
	public User getUserByName(@PathVariable("userName") String userName){
		return repo.findByName(userName);
	}
	
	@DeleteMapping ("/{userName}")
	public ResponseEntity<?> deleteByName( @PathVariable("userName") String userName) {
		
		if (repo.findByName(userName) == null){
			return ResponseEntity.badRequest().build();
		}
		
		repo.delete(this.getUserByName(userName));
		return ResponseEntity.ok().build();

	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User newUser){
			if(newUser.getName() == null
			    || newUser.getPassword() == null
			    || newUser.getEmail() == null) {
				
			}
			newUser = repo.save(newUser);
			return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{userName}")
	public ResponseEntity<?> updateByName(@RequestBody User newUser, @PathVariable("userName") String userName){
		if(newUser == null || repo.findByName(userName) == null) {
			return ResponseEntity.badRequest().build();
		}
		newUser.setId(repo.findByName(userName).getId());
		newUser = repo.save(newUser);
		return ResponseEntity.ok().build();
	}
	
	
}
