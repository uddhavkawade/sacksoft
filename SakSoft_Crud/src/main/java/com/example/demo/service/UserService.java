package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service 
public class UserService {
@Autowired 
private UserRepository urepo;
// save User
public User addUser(User user) {
	User savedUser = urepo.save(user);
	return savedUser;
}

// get all User
public List<User> getAllUser() {
	return urepo.findAll();

}
//get User by id
	public User getUserById(int User_ID) {
		
		return urepo.findById(User_ID)
				.orElseThrow(() -> new ResourceNotFoundException("This User Id Does Not Exists " + User_ID));
	}

	// delete User
	public void delete(int User_ID) {
		urepo.deleteById(User_ID);
	}

	// update User
	User updateUser(User user, int User_ID) {
		return urepo.save(user);

	}
	/*
	 * // search User on the basis of query public List<User> searcheuser(String
	 * query) { List<User> user = urepo.searcheuser(query); return user; }
	 */

}
