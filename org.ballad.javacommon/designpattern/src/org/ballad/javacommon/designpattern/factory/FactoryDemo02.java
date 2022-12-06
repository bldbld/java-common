package org.ballad.javacommon.designpattern.factory;

/**
 * 一个基本的使用Factory模式的示例。
 * 
 * @author BkinZou
 * @version 0.1 02/22/2011
 */
public class FactoryDemo02 {
	public static DaoDemo getDemoDao() {
		DaoDemo demoDao = null;
		try {
			Class c = Class.forName(JNDIDemo.DEMO_DAO_CLASS);
			demoDao = (DaoDemo) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demoDao;
	}

	public static void main(String[] args) {
		DaoDemo dao = FactoryDemo02.getDemoDao();
		dao.run();
	}
}

/**
 * DAO基类，定义了DAO的方法。
 */
class DaoDemo {
	/**
	 * 一个示例方法。
	 */
	public void run() {
	}
}

/**
 * DAO子类，编写了具体的DAO方法。
 */
class CatDaoDemo extends DaoDemo {
	/**
	 * CatDaoDemo重写了基类的run方法。
	 */
	public void run() {
		System.out.println("Cat is running! MySQL or NoSQL Database?");
	}
}

/**
 * JNDI类。
 */
class JNDIDemo {
	/**
	 * 用于定义DAO类的静态变量，当我们需要改变生成的DAO的具体类时，只需要写好对应的DAO，并修改此值。
	 */
	public static String DEMO_DAO_CLASS = "gusset.coding.designpattern.factory.CatDaoDemo";
}
