package com.webcloud.test;



import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webcloud.dao.FileforusrMapper;
import com.webcloud.entity.Fileforusr;

public class SpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//º”‘ÿspring»›∆˜
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		try{
			FileforusrMapper fileforusrMapper = (FileforusrMapper)ac.getBean("fileforusrMapper");
			List<Fileforusr> fileforusrlist = fileforusrMapper.selectByUid(2);
			for(int i=0;i<fileforusrlist.size();i++){
				Fileforusr fileforusr = fileforusrlist.get(i) ;
				System.out.println(fileforusr.getUfilename());
			}
			Map map = null;
			map.put("fileforusrlist", fileforusrlist);
			System.out.println(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
