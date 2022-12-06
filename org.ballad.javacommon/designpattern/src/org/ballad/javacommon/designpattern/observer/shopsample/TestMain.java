package org.ballad.javacommon.designpattern.observer.shopsample;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductNameObserver nameObserver = new ProductNameObserver();
		ProductPriceObserver priceObserver = new ProductPriceObserver();
		
		Product p = new Product("MP3", 1000d);
		
		p.addObserver(nameObserver);
		p.addObserver(priceObserver);
		
		p.setName("MP4");
		p.setPrice(1500d);

	}
}
