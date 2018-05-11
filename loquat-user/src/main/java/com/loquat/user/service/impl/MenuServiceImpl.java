package com.loquat.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loquat.user.entity.Menu;
import com.loquat.user.mapper.MenuMapper;
import com.loquat.user.service.MenuService;

@Service
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {
	
	@Autowired
	MenuMapper menuMapper;

	@Override
	public List<Menu> getMenusByUserId(Long userId) {
		return menuMapper.getMenusByUserId(userId);
	}

	@Override
	public List<Menu> menuTree() {
		return menuMapper.menuTree();
	}

	@Override
	public List<Long> getMenusByRoleId(Long roleId) {
		return menuMapper.getMenusByRoleId(roleId);
	}

}
