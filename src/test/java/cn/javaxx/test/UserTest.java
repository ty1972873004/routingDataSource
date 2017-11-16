package cn.javaxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.javaxxw.common.page.PageEntity;
import cn.javaxxw.common.page.PagingResult;
import cn.javaxxw.model.User;
import cn.javaxxw.service.UserService;


/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)
/** 声明spring主配置文件位置，注意：以当前测试类的位置为基准,有多个配置文件以字符数组声明 **/
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-mybatis.xml","classpath:applicationContext-mongodb.xml" })

public class UserTest {
	
		@Autowired
		private UserService userService;



	// @Test
	    public void addUser(){
	        System.out.println(userService.addUser("tuyong", "trazen", "1", 18));
	    }

	   @Test
		public void getAll(){
			List<User> list = userService.getAll();
			for( User user : list){
				System.out.println(user.getId()+user.getNickName());
			}
		}
		
		//@Test
	    public void testPage(){
	    	PageEntity pageEntity = new PageEntity();
	    	pageEntity.setPage(2);
	    	pageEntity.setSize(10);
	    	pageEntity.setOrderColumn("id");
	    	PagingResult<User> page = userService.selectPagination(pageEntity);
	    	System.out.println(page.getTotalSize()+"...."+page.getCurrentPage());
	    	for(User user : page.getResultList()){
	    		System.out.println(user.getId()+user.getNickName());
	    	}
	    	
	    }
	    
	    
	

}
