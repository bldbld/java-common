package org.ballad.javacommon.designpattern.factory;

/**
 * һ��ʹ��Factoryģʽ��Singletonģʽ��ʾ����
 * 
 * @author Ballad
 * @version 0.1 02/22/2011
 */
public class FactoryDemo01 {
	private static final Object initLock = new Object();
	private static final String className = "ballad.coding.designpattern.factory.FactoryDemo01";
	private static FactoryDemo01 factoryDemo;

	/**
	 * @param inputInfo
	 * @return factoryDemo
	 */
	public static FactoryDemo01 getInstance(Object inputInfo) {
		if (inputInfo == null) {
			return null;
		}
		/*
		 * �˴�ͬʱʹ����Singletonģʽ��
		 */
		if (factoryDemo == null) {
			synchronized (initLock) {
				if (factoryDemo == null) {
					/*
					 * ��̬�ļ����ࡣ
					 */
					try {
						Class c = Class.forName(className);
						factoryDemo = (FactoryDemo01) c.newInstance();
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		/*
		 * �˴��Ӽ�ķ�����factoryDemo������ʵ�ϣ����Է���һ��Proxy�������˻�Ȩ�޵���֤֮��ķ�����
		 */
		return factoryDemo.doAction(inputInfo);
	}

	/**
	 * �ڱ������пɶ��������ݽ��д������������û�ID������û���Ȩ�޵ȡ�
	 * 
	 * @param inputInfo
	 * @return factoryDemo
	 */
	public FactoryDemo01 doAction(Object inputInfo) {
		// ...
		System.out.println ("Get Factory by input : "+inputInfo.toString());
		return factoryDemo;
	}
	
	public static void main (String [] args){
		FactoryDemo01 testDemo = FactoryDemo01.getInstance("Tester 001");
	}
}
