package com.loquat.user.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface LoquatMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
