package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static String URL="jdbc:mysql://localhost:3306/edutest";
	private static String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static String PASSWORD="12346";
	/**
	 * 返回一个连接
	 * 
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动程序加载失败");
		}
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
		return conn;
	}
	
	
}
