package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.entity.User;
import com.example.model.mapper.UserMapper;

public class UserListController {

	
	@Autowired UserMapper userMapper;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userMapper.selectAll();
		
	}
}


