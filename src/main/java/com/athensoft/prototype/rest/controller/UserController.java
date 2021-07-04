package com.athensoft.prototype.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.prototype.rest.entity.User;
import com.athensoft.prototype.rest.service.UserService;



@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> getUserListAll() {
		LOGGER.debug("entering /users");
		return userService.getUserListAll();
	}

	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable int userId) {
		LOGGER.debug("entering /users/" + userId);
		return userService.getUserById(userId);
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		LOGGER.debug("entering /users");
		return userService.createUser(user);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		LOGGER.debug("entering /users");
		return userService.updateUser(user);
	}

	@DeleteMapping("/users/{userId}")
	public User deleteUserById(@PathVariable int userId) {
		LOGGER.debug("entering /users/" + userId);
		return userService.deleteUserById(userId);
	}

	@DeleteMapping("/users")
	public User deleteUser(@RequestBody User user) {
		LOGGER.debug("entering /users");
		return userService.deleteUser(user);
	}

}
