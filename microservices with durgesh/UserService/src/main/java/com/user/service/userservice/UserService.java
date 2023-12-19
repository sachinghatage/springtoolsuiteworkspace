package com.user.service.userservice;

import java.util.List;

import com.user.service.entity.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(int userId);

}
