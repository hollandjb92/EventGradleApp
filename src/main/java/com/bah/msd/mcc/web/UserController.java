package com.bah.msd.mcc.web;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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

	@GetMapping
	public Iterable<User> getAll() {
		return repo.findAll();
	}

//	@GetMapping("/{userId}")
//	public Optional<User> getUserById(@PathVariable("userId") long id){
//		return repo.findById(id);
//	}

	@GetMapping("/{userName}")
	public User getUserByName(@PathVariable("userName") String name) {

		return repo.findByName(name);

	}

	@DeleteMapping("/{userName}")
	public ResponseEntity<?> deleteByName(@PathVariable String userName) {

		if (repo.findByName(userName) == null) {
			return ResponseEntity.badRequest().build();
		}

		repo.delete(this.getUserByName(userName));
		return ResponseEntity.ok().build();

	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User newUser) {
		if (newUser.getId() != 0 || newUser.getName() == null || newUser.getEmail() == null
				|| newUser.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}

		newUser = repo.save(newUser);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{userName}")
	public ResponseEntity<?> putUser(@RequestBody User newUser, @PathVariable("userName") String userName) {
		if (newUser.getName() == null || newUser.getEmail() == null || newUser.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}

		newUser.setId(repo.findByName(userName).getId());
		newUser = repo.save(newUser);
		return ResponseEntity.ok().build();
	}

}
