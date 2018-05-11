package com.loquat.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.loquat.user.common.LoquatMapper;
import com.loquat.user.entity.Role;
import com.loquat.user.entity.User;

public interface UserMapper extends LoquatMapper<User>{
	
	User getByUserName(@Param("username") String username);
	
	List<Role> getRolesByUserId(@Param("userId") Long userId);
}
