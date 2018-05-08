package com.troy.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troy.test.data.dao.UserDao;
import com.troy.test.data.model.User;

@Service
public class UserService extends GenericService {

	@Autowired
	private UserDao userDao;

	public User getUserTest(String username) {
		try {
			System.out.println("Test");
			User user = this.userDao.insert(new User("John Doe", "john.doe@email.com", "john.doe", "password"));
			System.out.println("--------------Inserted User");

			Optional<User> userFound = this.userDao.findById(user.getUserId());
			return userFound != null ? userFound.get() : null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
