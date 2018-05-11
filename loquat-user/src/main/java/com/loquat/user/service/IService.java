package com.loquat.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T> {
	
	List<T> findAll();
	
	T findOne(Object id);
	
	int save(T entity);
	
	int delete(Object id);
	
	int updateAll(T entity);
	
	int updateNotNull(T entity);
	
	List<T> selectByExample(Object example);
}
