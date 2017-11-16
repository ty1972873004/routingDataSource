package cn.javaxxw.model;

import cn.javaxxw.common.model.BaseModel;

public class User extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5692218846299448289L;

	private String userName;
	
	private String nickName;
	
	private String sex;
	
	private Integer old;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getOld() {
		return old;
	}

	public void setOld(Integer old) {
		this.old = old;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", nickName=" + nickName + ", sex=" + sex + ", old=" + old + "]";
	}
	

}
