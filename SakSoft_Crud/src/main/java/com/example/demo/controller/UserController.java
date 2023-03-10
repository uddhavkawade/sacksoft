package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
@Autowired
private UserRepository urepo;
	// Save User
	@PostMapping("/saveUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
	//	User userSaved = userService.addUser(user);
		User userSaved = urepo.save(user);
		return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
	}

	// Fetch All User
	@GetMapping("/findAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listuser = userService.getAllUser();
		return new ResponseEntity<List<User>>(listuser, HttpStatus.OK);
	}

	// Get User By Id
	@GetMapping("/getUserById/{User_ID}")
	public ResponseEntity<User> getUseById(@PathVariable("User_ID") int User_ID) {
		User useById = userService.getUserById(User_ID);
		return new ResponseEntity<User>(useById, HttpStatus.OK);
	}

	// update User
	@PutMapping("/updateUser/{useid}")
	public ResponseEntity<User> updateUser(@PathVariable("useid") Integer User_ID, @RequestBody User user) {
		User user1 = userService.getUserById(User_ID);// find by id
		user1.setFirst_Name(user.getFirst_Name());
		user1.setLast_Name(user.getLast_Name());
		user1.setEmail_Id(user.getEmail_Id());
		user1.setAge(user.getAge());
		User updateUser = userService.addUser(user1);
		return ResponseEntity.ok().body(updateUser);
	}
	
	// Delete User
		@DeleteMapping("/deleteUser/{useid}")
		private String deleteBook(@PathVariable("useid") int User_ID) {
			userService.delete(User_ID);
			return "Deleted Successfully....!!!!";
		}

		/*
		 * // http://localhost:8087/search?query=y // search User on the basis
		 * 
		 * @GetMapping("/search") public ResponseEntity<List<User>>
		 * searcheuser(@RequestParam("query") String query) { return
		 * ResponseEntity.ok(userService.searcheuser(query)); }
		 */
}
