package dao;

public interface IUserDAO {
	/**
	 * 方法实现查找数据库中的当中是否有对应的用户名
	 */
	boolean searchUsername(String username);
	/**
	 * 根据一个用户名查找对应的密码
	 */
	String searchPassword(String username);
}
