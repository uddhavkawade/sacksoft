package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.User;



@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
	/*
	 * @Query("SELECT u FROM User u WHERE u.User LIKE CONCAT('%',:query, '%')")
	 * List<User> searcheuser(String query);
	 */
}
