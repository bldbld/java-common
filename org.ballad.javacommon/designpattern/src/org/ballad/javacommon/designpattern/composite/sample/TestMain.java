package org.ballad.javacommon.designpattern.composite.sample;

import java.util.Iterator;

/**
 * Composite<br>
 * 
 * @author Ballad
 * @date 2011-12-02
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EquipmentComposite composite = new EquipmentComposite();
		composite.add(new Disk());
		Iterator<Equipment> iter = composite.iterator();
		while (iter.hasNext()) {
			// Do something
		}
	}
}
