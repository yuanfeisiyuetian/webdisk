package com.webcloud.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.webcloud.dao.GroupMapper;
import com.webcloud.entity.Group;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File file = new File("src/mybatis.xml");
			InputStream is = new FileInputStream(file);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = sessionFactory.openSession();
			
			//登陆测试
//			UserMapper userMapper = (UserMapper)session.getMapper(UserMapper.class);
//			Scanner input = new Scanner(System.in);
//			System.out.println("请输入邮箱");
//			String email = input.next();
//			System.out.println("请输入登陆密码");
//			String password = input.next();
//			input.close();
//			User user = new User();
//			user.setUemail(email);
//			user.setPasswordhash(password);
//			//调用登陆的方法
//			User loginuser = userMapper.selectLoginUser(user);
//			if(loginuser == null){
//				System.out.println("邮箱或密码不正确");
//			}else{
//				System.out.println("登陆成功");
//				FileforusrMapper fileforusrMapper  = session.getMapper(FileforusrMapper.class);
//				List<Fileforusr> fileList = fileforusrMapper.selectByUid(loginuser.getUid());
//				for(Fileforusr ufile : fileList){
//					System.out.println(ufile.getUfilename()+"   "+ufile.getUsize()+"   "+ufile.getUploadtime());
//				}
//			}
			
			
			//文件上传测试
//			FileforusrMapper fileMapper = (FileforusrMapper)session.getMapper(FileforusrMapper.class);
//			Scanner input = new Scanner(System.in);
//			System.out.println("fid");
//			String fid = input.next();
//			Fileforusr fileforusr = new Fileforusr();
//			fileforusr.setUfileid(Integer.parseInt(fid));
//			fileforusr.setUid(2);
//			fileforusr.setUfilename("aaa");
//			fileMapper.insert(fileforusr);
			
			
			//查看群组测试？？一直报语法错误,md我忘记group是关键字了
			GroupMapper groupMapper = (GroupMapper)session.getMapper(GroupMapper.class);
			Group group = groupMapper.selectByPrimaryKey(1);
			System.out.println(group.getGname());
			
//			Group group = new Group();
//			group.setGid(3);
//			group.setGname("ssss");
//			group.setSetuptime(new Date());
//			groupMapper.insert(group);
			
			
			session.commit();
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
