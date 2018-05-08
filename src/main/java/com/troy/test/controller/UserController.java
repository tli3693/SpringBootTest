package com.troy.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.troy.test.data.model.User;
import com.troy.test.service.UserService;
import com.troy.test.service.security.util.JwtUtil;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserController extends GenericController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	@ResponseBody
	ResponseEntity<Map<String, Object>> registerUser(@RequestBody User user) throws Exception {
		// TODO: Connect to MongoDB to register User
		System.out.println("HERE!!!!");
		LOGGER.debug("HERE!!!!");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("success", Boolean.TRUE);
		return new ResponseEntity<Map<String, Object>>(responseBody, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping("/authenticate")
	@ResponseBody
	ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) throws Exception {
		// TODO: Connect to MongoDB to register User
		System.out.println("loginUser");
		LOGGER.debug("loginUser");
		if (user.getUsername() == null && user.getPassword() == null)
			throw new Exception("Invalid username or password!");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("success", Boolean.TRUE);
		responseBody.put("token", jwtUtil.generateToken(user));

		// TODO: Remove temp code
		user.setName("Troy Li");
		user.setEmail("troy@test.com");
		responseBody.put("user", user);

		this.userService.getUserTest(user.getUsername());

		System.out.println(user);
		return new ResponseEntity<Map<String, Object>>(responseBody, responseHeaders, HttpStatus.CREATED);
	}
}
