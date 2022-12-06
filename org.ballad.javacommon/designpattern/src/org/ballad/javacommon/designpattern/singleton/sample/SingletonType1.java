package org.ballad.javacommon.designpattern.singleton.sample;

/**
 * Singleton<br>
 * The singleton instance is created when the program starts.
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public class SingletonType1 {

	private static final SingletonType1 instance = new SingletonType1();

	private SingletonType1() {
	}

	public static SingletonType1 getInstance() {
		return instance;
	}
}
