package com.athensoft.prototype.rest.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.athensoft.prototype.rest.entity.User;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	public static final String API_SERVER = "http://localhost:8080";
	private final RestTemplate restTemplate;

	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<User> getUserListAll() {
		String targetUrl = API_SERVER + "/users";
		ResponseEntity<List<User>> response = restTemplate.exchange(targetUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		List<User> userList = response.getBody();
		LOGGER.debug("user list:" + userList);
		return userList;
	}

	public User getUserById(int userId) {
		try {
			String targetUrl = API_SERVER + "/users/" + userId;
			ResponseEntity<User> response = restTemplate.getForEntity(targetUrl, User.class);

			User user = response.getBody();
			LOGGER.debug("user:" + user);
			return user;
		} catch (HttpServerErrorException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public User createUser(User user) {
		try {
			String targetUrl = API_SERVER + "/users";
			HttpEntity<User> entity = new HttpEntity<>(user);
			ResponseEntity<User> response = restTemplate.postForEntity(targetUrl, entity, User.class);
			User createdUser = response.getBody();
			LOGGER.debug("user:" + createdUser);
			return createdUser;
		} catch (HttpServerErrorException e) {
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	public User updateUser(User user) {
		try {
			String targetUrl = API_SERVER + "/users";
			HttpEntity<User> entity = new HttpEntity<>(user);
			ResponseEntity<User> response = restTemplate.exchange(targetUrl, HttpMethod.PUT, entity, User.class);
			User updatedUser = response.getBody();
			LOGGER.debug("user:" + updatedUser);
			return updatedUser;
		} catch (HttpServerErrorException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public User deleteUserById(int userId) {
		try {
			String targetUrl = API_SERVER + "/users/" + userId;
			ResponseEntity<User> response = restTemplate.exchange(targetUrl, HttpMethod.PUT, null, User.class);
			User deletedUser = response.getBody();
			LOGGER.debug("user:" + deletedUser);
			return deletedUser;
		} catch (HttpServerErrorException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public User deleteUser(User user) {
		try {
			String targetUrl = API_SERVER + "/users";
			HttpEntity<User> entity = new HttpEntity<>(user);
			ResponseEntity<User> response = restTemplate.exchange(targetUrl, HttpMethod.DELETE, entity, User.class);
			User deletedUser = response.getBody();
			LOGGER.debug("user:" + deletedUser);
			return deletedUser;
		} catch (HttpServerErrorException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
