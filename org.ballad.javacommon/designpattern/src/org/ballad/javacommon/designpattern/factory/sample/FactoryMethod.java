package org.ballad.javacommon.designpattern.factory.sample;

/**
 * Factory Method Sample. <br>
 * Factory Method can be used like below codes; <br>
 * <code>
 * FactoryMethod sampleA = FactoryMethod.newInstance(0);<br>
 * FactoryMethod sampleB = FactoryMethod.newInstance(1);<br>
 * </code>
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public class FactoryMethod {

	public static Sample newInstance(int type) {
		// This code style is for testing, usually we use getClass method to
		// load the destination Class dynamically.
		if (type == 0) {
			return new SampleA();
		} else {
			return new SampleB();
		}
	}
}

interface Sample {
}

class SampleA implements Sample {
}

class SampleB implements Sample {
}
