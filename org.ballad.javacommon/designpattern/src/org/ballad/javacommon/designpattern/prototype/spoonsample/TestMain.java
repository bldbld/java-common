package org.ballad.javacommon.designpattern.prototype.spoonsample;

/**
 * A Demo for Prototype - Spoon Sample.<br>
 * Definition: Using the ProtoType to select Destination Class, and create new
 * Object by copying the ProtoType Object.<br>
 * 
 * @author Ballad
 * @date 2011-11-30
 */
public class TestMain {

	/**
	 * Test Main Method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractSpoon so;

		so = new SoupSpoon();
		System.out.println(so.getSpoonName());

		so = new SaladSpoon();
		System.out.println(so.getSpoonName());

		// The output is:
		// Soup Spoon
		// Salad Spoon
	}
}
