package cn.javaxxw.model;

import java.util.Date;

import cn.javaxxw.common.model.BaseModel;

public class Log extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -589442635376149229L;
	
	private String userName;
	
	private String desc;
	
	private String url;
	
	private String method;
	
	private Date CreateTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}

	@Override
	public String toString() {
		return "Log [userName=" + userName + ", desc=" + desc + ", url=" + url + ", method=" + method + ", CreateTime="
				+ CreateTime + "]";
	}
	
	
	
	
	

}
