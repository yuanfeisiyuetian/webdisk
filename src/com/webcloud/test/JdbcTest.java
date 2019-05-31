package com.webcloud.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

	public static void main(String[] args) {
		try{
			// TODO Auto-generated method stub
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/webcloud";
			String username = "root";
			String password = "Lwx980430";
			Connection coon = DriverManager.getConnection(url,username,password);
			String sqlStr = "select * from user";
			PreparedStatement pstmt = coon.prepareStatement(sqlStr);
			ResultSet rst = pstmt.executeQuery();
			System.out.println("id\t name\t email\t ");
			while(rst.next()){
				String id = rst.getString("UID");
				String name = rst.getString("UName");
				String email = rst.getString("UEmail");
				System.out.println(id+"\t"+name+"\t"+email);
			}
			rst.close();
			pstmt.close();
			coon.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
