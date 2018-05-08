package com.troy.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.troy.test.data.model.MyModel;

@RestController
@EnableAutoConfiguration
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	private static final String TEST_EXCEPTION = "THIS IS A TEST EXCEPTION";
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/mytest/{id}")
	MyModel mytest(@PathVariable int id) throws Exception {
		if (id == 5) {
			LOGGER.error(TEST_EXCEPTION);
			throw new Exception(TEST_EXCEPTION);
		}
		return new MyModel("TEST", 123L);
	}
//java -jar target/SpringBootTest-0.0.1-SNAPSHOT.jar
}
