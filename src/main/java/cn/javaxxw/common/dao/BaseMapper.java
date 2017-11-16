package cn.javaxxw.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.javaxxw.common.page.PageEntity;
import cn.javaxxw.common.page.PagingResult;

public  abstract class BaseMapper <T> extends SqlSessionDaoSupport implements GenericDao<T>{
	
	protected Class<T> entityClass;  
	
	// sqlmap.xml定义文件中对应的sqlid  
	public static final String SQLID_INSERT = "insert";  
	
    public static final String SQLID_INSERT_BATCH = "insertBatch";  
    
    public static final String SQLID_UPDATE = "update";  
    
    public static final String SQLID_UPDATE_BY_PARAM = "updateByParam";  
    
    public static final String SQLID_DELETE_BY_PK = "deleteByPk";  
    
    public static final String SQLID_DELETE_BY_PARAM = "deleteByParam";  
    
    public static final String SQLID_DELETE_BATCH = "deleteBatch";  
    
    public static final String SQLID_COUNT = "count";  

    public static final String SQLID_COUNT_PARAM = "countByParam";  

    public static final String SQLID_SELECT_BY_PK = "selectByPk";  

    public static final String SQLID_SELECT = "selectAll";  
    
    public static final String SQLID_SELECT_BY_PARAM = "selectByParam";  
    
    
    
	@Resource(name = "sqlSessionTemplate")  
    public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {  
        super.setSqlSessionTemplate(sqlSessionTemplate);  
    }  
	
	@SuppressWarnings("unchecked")
	public BaseMapper(){  
        this.entityClass = (Class<T>) getClass(); 
    } 
	
	 
	@Override
	 public int insert(T entity) {  
        int rows = 0;  
        try {  
            rows = getSqlSession().insert(entityClass.getName() + "." + SQLID_INSERT,  
                    entity);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return rows;  
    } 
	
	@Override
	public int update(T entity) {
	    int rows = 0;  
        try {  
            rows = getSqlSession().update(entityClass.getName() + "." + SQLID_UPDATE,  
                    entity);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return rows;  
	}
	
	@Override
	public int updateByParam(Map<String, Object> param) {
		int rows = 0;  
        try {  
            rows = getSqlSession().update(entityClass.getName() + "." + SQLID_UPDATE_BY_PARAM,  
                    param);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return rows;  
	}
	
	@Override
	public int deleteByPk(Serializable primaryKey) {
	 int rows = 0;  
        try {  
            rows = getSqlSession().delete(entityClass.getName() + "." + SQLID_DELETE_BY_PK,  
                    primaryKey);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return rows;  
	}
	
	@Override
	public int deleteByParam(Map<String, Object> param) {
		int rows = 0;  
        try {  
            rows = getSqlSession().delete(entityClass.getName() + "." + SQLID_DELETE_BY_PARAM,  
                    param);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return rows;  
	}
	
	@Override
	public int deleteBatch(List<Serializable> list) {
	    try {  
            return getSqlSession().delete(entityClass.getName() + "." + SQLID_DELETE_BATCH,list);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
	}
	
	@Override
	public int count() {
		int result = 0;  
        try {  
            result = getSqlSession().selectOne(entityClass.getName() + "." + SQLID_COUNT);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
	}
	
	@Override
	public int countByParam(Map<String,Object> param) {
		 int result = 0;  
	        try {  
	            result = getSqlSession().selectOne(entityClass.getName() + "." + SQLID_COUNT_PARAM,param);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return result;  
	}
	
	@Override
	public T get(Serializable primaryKey) {
		 try {  
	            return getSqlSession().selectOne(entityClass.getName() + "." + SQLID_SELECT_BY_PK,primaryKey);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	}
	
	@Override
	public List<T> selectAll() {
		 try {  
	            return getSqlSession().selectList(entityClass.getName() + "." + SQLID_SELECT);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	}
	
	@Override
	public List<T> selectByParam(Map<String, Object> param) {
		   try {  
	            return getSqlSession().selectList(entityClass.getName() + "." + SQLID_SELECT_BY_PARAM,param);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	}
	
	@Override
	public PagingResult<T> selectPagination(PageEntity pageEntity) {
		try {  
            int page = pageEntity.getPage() == null || "".equals(pageEntity.getPage()) ? 1 : pageEntity.getPage(); //默认为第一页  
            int size = pageEntity.getSize() == null || "".equals(pageEntity.getSize()) ? 10 : pageEntity.getSize();; //默认每页10个  
              
            RowBounds rowBounds = new RowBounds((page-1)*size, size);  
              
            Map<String,Object> param = pageEntity.getParams();  
            if (param != null) {  
                param.put("orderColumn", pageEntity.getOrderColumn());  
                param.put("orderTurn", pageEntity.getOrderType());  
            }else {  
                param = new HashMap<String,Object>();  
                param.put("orderColumn", pageEntity.getOrderColumn());  
                param.put("orderTurn", pageEntity.getOrderType());  
            }  
              
            List<T> resultList = getSqlSession().selectList(entityClass.getName() + "." + SQLID_SELECT_BY_PARAM,param,rowBounds);  
            int totalSize = countByParam(pageEntity.getParams());  
              
            PagingResult<T> pagingResult = new PagingResult<T>();  
            pagingResult.setCurrentPage(page);  
            pagingResult.setTotalSize(totalSize);  
            pagingResult.setResultList(resultList);  
            
            return pagingResult;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
	}
	
	

}
