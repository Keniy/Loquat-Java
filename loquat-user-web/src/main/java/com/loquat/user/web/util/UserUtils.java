package com.loquat.user.web.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.loquat.user.entity.User;

public class UserUtils {
	
	public static User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
