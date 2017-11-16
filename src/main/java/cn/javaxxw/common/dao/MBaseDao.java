package cn.javaxxw.common.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import cn.javaxxw.common.page.Page;

public interface MBaseDao {
	
	<T> T find(Class<T> entityClass,Query query);
	
	<T> T findById(Class<T> entityClass, Object id);

	<T> List<T> findAll(Class<T> entityClass);

	void remove(Object obj);
	
	<T> void remove(String id,Class<T> entityClass);
	
	void add(Object obj);
	
	void add(Object obj, String collection);

	void saveOrUpdate(Object obj);
	
	void saveOrUpdate(Object obj,String conllection);
	
	<T> WriteResult updateObject(Class<T> entityClass,Query query,Update update);
	
	<T> List<T> findByQuery(Class<T> entityClass, Query query, Page page);
	
    <T> Long count(Class<T> entityClass, Query query);

}
