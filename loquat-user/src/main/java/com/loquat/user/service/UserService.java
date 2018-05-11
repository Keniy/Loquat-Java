package com.loquat.user.service;

import java.util.List;

import com.loquat.user.entity.Role;
import com.loquat.user.entity.User;

public interface UserService extends IService<User>{
	
	List<Role> getRolesByUserId(Long userId);
	
	boolean register(User user);
}
