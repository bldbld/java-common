package org.ballad.javacommon.designpattern.composite.sample;

public interface Equipment {
	// public boolean hasNext ();
    double getPrice();

	boolean add(Equipment equipment);

	boolean remove(Equipment equipment);
}
