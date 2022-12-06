package org.ballad.javacommon.designpattern.composite.sample;

public class Disk implements Equipment {

	private final double price = 10d;

	@Override
	public boolean add(Equipment equipment) {
		return false;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public boolean remove(Equipment equipment) {
		return false;
	}
}
