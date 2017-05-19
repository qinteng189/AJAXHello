package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao.IUserDAO;

public class Factory {
	//声明一个属性类用来解析属性文件
	private static Properties properties = new Properties();
	//静态代码块来加载属性文件
	static {
		//声明一个输入流
		InputStream ips=null;
		//生成一个类加载器
		//解析工厂类的字节码文件
		ClassLoader loader=Factory.class.getClassLoader();
		//通过类加载器加载属性文件，获取加载器的输入流
		ips=loader.getResourceAsStream("util/dao.properties");
		//把属性文件读取到Properties
		try {
			properties.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("属性文件加载失败");
		}
	}
	/**
	 * 解析属性文件中的数据
	 * 
	 */
	public static String getValue(String key){
		return properties.getProperty(key);
	}
	/**
	 * 方法:返回值是一个类对象初始化对象关系
	 */
	public static Object getInstance(String type){
		Object obj=null;
		//先拿到对象类名字
		String classname =getValue(type);
		 try {
			 //通过反射透析字节码对象获得类
			Class c=Class.forName(classname);
			obj=c.newInstance();//生成对象
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("反射出错");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("访问非法");
		}
		return obj;
	}
	public static void main(String[] args) {
		IUserDAO dao=(IUserDAO)Factory.getInstance("IUserDAO");
		System.out.println(dao.searchPassword("admin2"));
	}
}
