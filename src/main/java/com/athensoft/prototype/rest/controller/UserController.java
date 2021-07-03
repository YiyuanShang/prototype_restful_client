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

	@GetMapping("/user/list")
	public List<User> getUserListAll() {
		LOGGER.debug("entering /user/list");
		return userService.getUserListAll();
	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable int userId) {
		LOGGER.debug("entering /user/" + userId);
		return userService.getUserById(userId);
	}

	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) {
		LOGGER.debug("entering /user/create");
		return userService.createUser(user);
	}

	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		LOGGER.debug("entering /user/update");
		return userService.updateUser(user);
	}

	@DeleteMapping("/user/delete/{userId}")
	public User deleteUserById(@PathVariable int userId) {
		LOGGER.debug("entering /user/delete/" + userId);
		return userService.deleteUserById(userId);
	}

	@DeleteMapping("/user/delete")
	public User deleteUser(@RequestBody User user) {
		LOGGER.debug("entering /user/delete");
		return userService.deleteUser(user);
	}

}
