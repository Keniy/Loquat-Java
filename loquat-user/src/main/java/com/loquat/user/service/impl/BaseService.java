package com.loquat.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loquat.user.service.IService;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseService<T> implements IService<T>{
	
	@Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

	@Override
	public T findOne(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(T entity) {
		return mapper.insert(entity);
	}

	@Override
	public int delete(Object id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateAll(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	public int updateNotNull(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	@Override
	public List<T> findAll() {
		return mapper.selectAll();
	}

}
