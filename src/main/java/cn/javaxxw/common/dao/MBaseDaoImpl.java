package cn.javaxxw.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import cn.javaxxw.common.page.Page;


@Repository(value="mBaseDao")
public class MBaseDaoImpl implements MBaseDao{
	
	@Autowired
	@Qualifier("mongoTemplate")
	protected MongoTemplate mongoTemplate;

	@Override
	public <T> T find(Class<T> entityClass, Query query) {
		return this.mongoTemplate.findOne(query, entityClass);
	}

	@Override
	public <T> T findById(Class<T> entityClass, Object id) {
		return this.mongoTemplate.findById(id, entityClass);
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		return this.mongoTemplate.findAll(entityClass);
	}

	@Override
	public void remove(Object obj) {
		this.mongoTemplate.remove(obj);
	}
	
	@Override
	public <T> void remove(String id, Class<T> entityClass) {
		this.mongoTemplate.remove(findById(entityClass, id));
	}

	@Override
	public void add(Object obj) {
		this.mongoTemplate.insert(obj);
	}
	
	@Override
	public void add(Object obj, String collection) {
		this.mongoTemplate.insert(obj,collection);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		this.mongoTemplate.save(obj);
	}

	@Override
	public void saveOrUpdate(Object obj, String conllection) {
		this.mongoTemplate.save(obj, conllection);
	}

	@Override
	public <T> WriteResult updateObject(Class<T> entityClass, Query query, Update update) {
		return this.mongoTemplate.updateFirst(query, update, entityClass);
	}

	@Override
	public <T> List<T> findByQuery(Class<T> entityClass, Query query, Page page) {
		Long count = this.count(entityClass, query);
		page.setCount(count);
		int pageNumber = page.getCurrent();
		int pageSize = page.getPageCount();
		query.skip((pageNumber - 1) * pageSize).limit(pageSize);
		return this.mongoTemplate.find(query, entityClass);
	}
	
	@Override
	public <T> Long count(Class<T> entityClass, Query query) {
		return this.mongoTemplate.count(query, entityClass);
	}

	
	
	
	
	
	

}
