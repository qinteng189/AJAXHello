package dao;

public interface IUserDAO {
	/**
	 * ����ʵ�ֲ������ݿ��еĵ����Ƿ��ж�Ӧ���û���
	 */
	boolean searchUsername(String username);
	/**
	 * ����һ���û������Ҷ�Ӧ������
	 */
	String searchPassword(String username);
}
