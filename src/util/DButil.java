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
	 * ����һ������
	 * 
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����������ʧ��");
		}
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ��");
		}
		return conn;
	}
	
	
}
