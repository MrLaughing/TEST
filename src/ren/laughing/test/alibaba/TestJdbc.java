package ren.laughing.test.alibaba;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("","","");
			Statement stat = conn.createStatement();
//			String sql = "select * from table where name = "+"lilei"+"and password = "+"123456";
			String sql = "select * from table where name = "+"lilei"+"and password = "+"'123456'or'1'='+1";
			ResultSet res = stat.executeQuery("");
			if(res.next()){
				System.out.println(res.getString(""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
