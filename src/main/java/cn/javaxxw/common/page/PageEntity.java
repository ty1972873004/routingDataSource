package cn.javaxxw.common.page;

import java.util.Map;

/**
 * 分页参数
 * @author tuyong
 *
 */
public class PageEntity {
	
	
	/**
	 * 当前页数
	 */
	private Integer page;
	
	/**
	 * 页大小
	 */
	private Integer size;
	
	/**
	 * 参数
	 */
	private Map<String,Object> params;
	
	/**
	 * 排序列
	 */
	private String orderColumn;
	
	/**
	 * 排序类型
	 */
	private String OrderType = "ASC";

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}


	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderType() {
		return OrderType;
	}

	public void setOrderType(String orderType) {
		OrderType = orderType;
	}
	

}
