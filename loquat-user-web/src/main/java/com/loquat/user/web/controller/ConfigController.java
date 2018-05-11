package com.loquat.user.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loquat.user.entity.Menu;
import com.loquat.user.entity.User;
import com.loquat.user.service.MenuService;
import com.loquat.user.web.util.UserUtils;

@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/sysmenu")
	public List<Menu> sysMenu() {
		return menuService.getMenusByUserId(UserUtils.getCurrentUser().getId());
	}
	
	@RequestMapping("/user")
	public User currentUser() {
		return UserUtils.getCurrentUser();
	}
}
