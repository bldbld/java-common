package org.ballad.javacommon.designpattern.observer.shopsample;

import java.util.Observable;

public class Product extends Observable {

	private String name;

	private double price;

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		// Notify Observer
		this.notifyObservers(name);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		// Notify Observer
		this.notifyObservers(price);
	}
}
