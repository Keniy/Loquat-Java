package com.loquat.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.loquat.user.common.LoquatMapper;

public interface MenuRoleMapper{
	
	int deleteMenuByRoleId(@Param("roleId") Long roleId);
	
	int addMenu(@Param("roleId") Long roleId, @Param("mids") Long[] mids);
}
