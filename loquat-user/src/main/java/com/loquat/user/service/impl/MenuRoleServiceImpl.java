package com.loquat.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loquat.user.mapper.MenuRoleMapper;
import com.loquat.user.service.MenuRoleService;

@Service
public class MenuRoleServiceImpl implements MenuRoleService{
	
	@Autowired
	MenuRoleMapper menuRoleMapper;

	@Override
	public int deleteMenuByRoleId(Long roleId) {
		return menuRoleMapper.deleteMenuByRoleId(roleId);
	}

	@Override
	public int addMenu(Long roleId, Long[] mids) {
		this.deleteMenuByRoleId(roleId);
		if (mids.length == 0) {
			return 0;
		}
		return menuRoleMapper.addMenu(roleId, mids);
	}

}
