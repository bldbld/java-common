package org.ballad.javacommon.designpattern.observer.shopsample;

import java.util.Observable;
import java.util.Observer;

public class ProductPriceObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Double) {
			System.out.println("The Price changed:" + arg);
		}

	}

}
