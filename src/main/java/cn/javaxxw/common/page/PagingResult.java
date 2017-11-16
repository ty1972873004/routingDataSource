package cn.javaxxw.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 * @author tuyong
 *
 * @param <T>
 */
public class PagingResult<T> {
	
	/**
	 * 当前页数
	 */
    private Integer currentPage;  
    
    /**
     * 总页数
     */
    private Integer totalSize;  
    
    /**
     * 结果集
     */
    private List<T> resultList = new ArrayList<T>();

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}  
}
