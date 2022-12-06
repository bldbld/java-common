package org.ballad.javacommon.designpattern.facade.sample;

/**
 * Facade<br>
 * Facade主要用于降低耦合度，其实此模式已经很广泛的应用了。
 * 
 * @author Ballad
 * @date 2011-12-01
 */
public class SampleFacade {

	public SampleFacade() {
		// Do something
	}

	public void init() {
		// Do something
	}

	public Object process() {
		// Do something
		Object result = new Object();
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleFacade facadeTest = new SampleFacade();
		facadeTest.init();
		facadeTest.process();
	}
}
