package cn.javaxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.javaxxw.common.page.Page;
import cn.javaxxw.model.Log;
import cn.javaxxw.service.LogService;

/** 声明用的是Spring的测试类 **/
@RunWith(SpringJUnit4ClassRunner.class)
/** 声明spring主配置文件位置，注意：以当前测试类的位置为基准,有多个配置文件以字符数组声明 **/
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-mybatis.xml","classpath:applicationContext-mongodb.xml" })  

public class LogTest {
	
	@Autowired
	private LogService logService;
	
	@Test
	public void test(){
		Log log = new Log();
		log.setId(22);
		log.setUserName("tuyong");
//		logService.add(log,"log");
		List<Log> logs = logService.findAll(Log.class);
		log = new Log();
		//log = logService.findById(Log.class, 12);
		Query query = new Query(Criteria.where("id").is(12));
//		log = logService.find(Log.class, query);
		
		Query query1 = new Query(Criteria.where("userName").is("tuyong"));
		Page page = new Page();
		page.setCurrent(2);
		List<Log> logs1 = logService.findByQuery(Log.class, query1, page);
		System.err.println(page.getCount());
		System.err.println(page.getPages());
		System.err.println(page.getCurrent());
		System.out.println(logs1.size());
		System.out.println(log.toString());
	}

}
