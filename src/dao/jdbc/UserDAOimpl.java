package dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DButil;
import dao.IUserDAO;

public class UserDAOimpl implements IUserDAO {
	/**
	 * �����ڲ���Ա����,���ݿ�������࣬Ԥ���ص�SQL��䣬SQL���ִ�к󷵻صĽ����
	 */
	Connection conn;
	PreparedStatement prep;
	ResultSet rst;
	@Override
	public boolean searchUsername(String username) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String realname;
		try {
			conn=DButil.getConnection();
			prep=conn.prepareStatement("select username from t_user where username=?");
			prep.setString(1, username);
			rst=prep.executeQuery();
			if(rst.next()){
				
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rst!=null){
				try {
					//�رս����
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(prep!=null){
				//�ر�Ԥ���ص����
				try {
					prep.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				//�ر�����
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	@Override
	public String searchPassword(String username) {
		// TODO Auto-generated method stub
		String password=null;
		try {
			conn=DButil.getConnection();
			prep=conn.prepareStatement("select password from t_user where username=?");
			prep.setString(1, username);
			rst=prep.executeQuery();
			if(rst.next()){
				password=rst.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return password;
	}
	public static void main(String[] args) {
		UserDAOimpl dao = new UserDAOimpl();
		if(dao.searchUsername("admin9")){
			System.out.println("�ҵ�������û�");
		}else{
			System.out.println("û�ҵ�����û�");
		}
		System.out.println(dao.searchPassword("admin2"));
	}

}
