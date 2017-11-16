package cn.javaxxw.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.javaxxw.common.page.PageEntity;
import cn.javaxxw.common.page.PagingResult;

/**
 * 
 * @author tuyong
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao <T>{
	
	 /** 
     * 新增实体 
     * @param entity 
     * @return 影响记录条数 
     */  
    public abstract int insert(T entity);  
      
    /**  
     * 修改一个实体对象（UPDATE一条记录）  
     * @param entity 实体对象  
     * @return 修改的对象个数，正常情况=1  
     */    
    public abstract int update(T entity);    
        
    /**  
     * 修改符合条件的记录  
     * <p>此方法特别适合于一次性把多条记录的某些字段值设置为新值（定值）的情况，比如修改符合条件的记录的状态字段</p>  
     * <p>此方法的另一个用途是把一条记录的个别字段的值修改为新值（定值），此时要把条件设置为该记录的主键</p>  
     * @param param 用于产生SQL的参数值，包括WHERE条件、目标字段和新值等  
     * @return 修改的记录个数，用于判断修改是否成功  
     */    
    public abstract int updateByParam(Map<String,Object> param);    
        
    /**  
     * 按主键删除记录  
     * @param primaryKey 主键对象  
     * @return 删除的对象个数，正常情况=1  
     */    
    public abstract int deleteByPk(Serializable  primaryKey);    
    
    /**  
     * 删除符合条件的记录  
     * <p><strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong></p>  
     * @param param 用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）  
     * @return  
     */    
    public abstract int deleteByParam(Map<String,Object> param);    
    
    /**  
     * 批量删除  
     * @param list  
     */    
    public abstract int deleteBatch(final List<Serializable> list);    
   
        
    /**  
     * 查询整表总记录数  
     * @return 整表总记录数  
     */    
    public abstract int count();    
        
    /**  
     * 查询符合条件的记录数  
     * @param param 查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于count()  
     * @return  
     */    
    public abstract int countByParam(Map<String,Object> param);    
    
    /**  
     * 按主键取记录  
     * @param primaryKey 主键值  
     * @return 记录实体对象，如果没有符合主键条件的记录，则返回null  
     */    
    public abstract T get(Serializable primaryKey);    
    
    /**  
     * 取全部记录  
     * @return 全部记录实体对象的List  
     */    
    public abstract List<T> selectAll();    
        
    /**  
     * 按条件查询记录  
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件  
     * @return 符合条件记录的实体对象的List  
     */    
    public abstract List<T> selectByParam(Map<String,Object> param);    
        
    /**  
     * 按条件查询记录，并处理成分页结果  
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件  
     * @return PaginationResult对象，包括（符合条件的）总记录数、页实体对象List等  
     */    
    public abstract PagingResult<T> selectPagination(PageEntity param);    
	

}
