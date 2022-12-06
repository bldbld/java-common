package org.ballad.javacommon.designpattern.factory;

/**
 * һ��������ʹ��Factoryģʽ��ʾ����
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
 * DAO���࣬������DAO�ķ�����
 */
class DaoDemo {
	/**
	 * һ��ʾ��������
	 */
	public void run() {
	}
}

/**
 * DAO���࣬��д�˾����DAO������
 */
class CatDaoDemo extends DaoDemo {
	/**
	 * CatDaoDemo��д�˻����run������
	 */
	public void run() {
		System.out.println("Cat is running! MySQL or NoSQL Database?");
	}
}

/**
 * JNDI�ࡣ
 */
class JNDIDemo {
	/**
	 * ���ڶ���DAO��ľ�̬��������������Ҫ�ı����ɵ�DAO�ľ�����ʱ��ֻ��Ҫд�ö�Ӧ��DAO�����޸Ĵ�ֵ��
	 */
	public static String DEMO_DAO_CLASS = "gusset.coding.designpattern.factory.CatDaoDemo";
}
