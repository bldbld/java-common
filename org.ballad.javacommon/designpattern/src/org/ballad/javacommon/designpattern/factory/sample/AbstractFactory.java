package org.ballad.javacommon.designpattern.factory.sample;

/**
 * Abstract Factory Sample. <br>
 * There two kind of Factory, Factory Method and Abstract Factory.<br>
 * Code Example:<br>
 * <code>
 * TypeA typeA = Product1Factory.newInstanceA(0);<br>
 * TypeB typeB = Product2Factory.newInstanceA(0);<br>
 * </code>
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public abstract class AbstractFactory {

	public abstract TypeA newInstanceA(int type);

	public abstract TypeB newInstanceB(int type);
}

/**
 * Factory 1.
 */
class Product1Factory extends AbstractFactory {

	@Override
	public TypeA newInstanceA(int type) {
		// Do something.
		return null;
	}

	@Override
	public TypeB newInstanceB(int type) {
		// Do something.
		return null;
	}
}

/**
 * Factory 2.
 */
class Product2Factory extends AbstractFactory {

	@Override
	public TypeA newInstanceA(int type) {
		// Do something.
		return null;
	}

	@Override
	public TypeB newInstanceB(int type) {
		// Do something.
		return null;
	}
}

interface TypeA {
}

interface TypeB {
}

class Product1TypeA implements TypeA {
}

class Product1TypeB implements TypeB {
}

class Product2TypeA implements TypeA {
}

class Product2TypeB implements TypeB {
}
