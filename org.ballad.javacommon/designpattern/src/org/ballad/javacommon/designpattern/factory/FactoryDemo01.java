package org.ballad.javacommon.designpattern.factory;

/**
 * 一个使用Factory模式和Singleton模式的示例。
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
		 * 此处同时使用了Singleton模式。
		 */
		if (factoryDemo == null) {
			synchronized (initLock) {
				if (factoryDemo == null) {
					/*
					 * 动态的加载类。
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
		 * 此处从简的返回了factoryDemo对象，事实上，可以返回一个Proxy，用于账户权限的验证之类的方法。
		 */
		return factoryDemo.doAction(inputInfo);
	}

	/**
	 * 在本方法中可对输入数据进行处理。例如输入用户ID，获得用户的权限等。
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
