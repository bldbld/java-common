package org.ballad.javacommon.designpattern.singleton.sample;

/**
 * Singleton<br>
 * The singleton instance is created when the method getInstance called firstly.
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public class SingletonType2 {

	private static SingletonType2 instance;

	private SingletonType2() {
	}

	// The method getInstance must be a synchronous method,
	// because if not we may get more instances than one .
	public static synchronized SingletonType2 getInstance() {
		// Lazy Initialisation
		if (instance == null) {
			instance = new SingletonType2();
		}
		return instance;
	}
}
