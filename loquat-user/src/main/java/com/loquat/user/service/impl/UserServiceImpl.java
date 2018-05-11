package com.loquat.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loquat.user.entity.Role;
import com.loquat.user.entity.User;
import com.loquat.user.mapper.UserMapper;
import com.loquat.user.service.UserService;

@Service
public class UserServiceImpl extends BaseService<User> implements UserDetailsService, UserService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}


	@Override
	public List<Role> getRolesByUserId(Long userId) {
		return userMapper.getRolesByUserId(userId);
	}


	@Override
	public boolean register(User user) {
		User u = userMapper.getByUserName(user.getUsername());
		if(u != null) {
			return false;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(user.getPassword());
		user.setPassword(encode);
//		return userMapper.insert(user) == 1 ? true :false;
		return false;
	}

}
