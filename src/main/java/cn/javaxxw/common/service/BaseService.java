package cn.javaxxw.common.service;

import java.util.List;

import cn.javaxxw.common.datasource.DataSource;
import cn.javaxxw.common.model.BaseModel;
import cn.javaxxw.common.page.PageEntity;
import cn.javaxxw.common.page.PagingResult;

public interface BaseService<T extends BaseModel> {

    @DataSource("write")
	int insertOrUpdate(T t);

    @DataSource("read")
	T findByPk(int id);

    @DataSource("read")
    List<T> getAll();

    @DataSource("read")
    PagingResult<T> selectPagination(PageEntity pageEntity);
	
	
	

}
