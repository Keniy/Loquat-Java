package com.loquat.user.mapper;

import java.util.List;

import com.loquat.user.common.LoquatMapper;
import com.loquat.user.entity.Menu;

public interface MenuMapper extends LoquatMapper<Menu>{
	
	List<Menu> getMenusByUserId(Long userId);
	
	List<Menu> menuTree();
	
	List<Long> getMenusByRoleId(Long roleId);
}
