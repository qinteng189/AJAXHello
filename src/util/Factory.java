package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao.IUserDAO;

public class Factory {
	//����һ���������������������ļ�
	private static Properties properties = new Properties();
	//��̬����������������ļ�
	static {
		//����һ��������
		InputStream ips=null;
		//����һ���������
		//������������ֽ����ļ�
		ClassLoader loader=Factory.class.getClassLoader();
		//ͨ������������������ļ�����ȡ��������������
		ips=loader.getResourceAsStream("util/dao.properties");
		//�������ļ���ȡ��Properties
		try {
			properties.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�����ļ�����ʧ��");
		}
	}
	/**
	 * ���������ļ��е�����
	 * 
	 */
	public static String getValue(String key){
		return properties.getProperty(key);
	}
	/**
	 * ����:����ֵ��һ��������ʼ�������ϵ
	 */
	public static Object getInstance(String type){
		Object obj=null;
		//���õ�����������
		String classname =getValue(type);
		 try {
			 //ͨ������͸���ֽ����������
			Class c=Class.forName(classname);
			obj=c.newInstance();//���ɶ���
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ʷǷ�");
		}
		return obj;
	}
	public static void main(String[] args) {
		IUserDAO dao=(IUserDAO)Factory.getInstance("IUserDAO");
		System.out.println(dao.searchPassword("admin2"));
	}
}
