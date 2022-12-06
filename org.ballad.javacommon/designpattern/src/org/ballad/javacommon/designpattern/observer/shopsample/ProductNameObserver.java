package org.ballad.javacommon.designpattern.observer.shopsample;

import java.util.Observable;
import java.util.Observer;

public class ProductNameObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("The Name changed:");
		if (arg instanceof String) {
			System.out.println("The Name changed:" + arg);
		}

	}

}
