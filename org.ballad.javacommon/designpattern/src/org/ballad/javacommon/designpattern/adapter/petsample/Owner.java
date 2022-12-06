package org.ballad.javacommon.designpattern.adapter.petsample;

public class Owner {
	public static void main(String[] args) {
		Dog dog = new Dog ();
		CatDogAdapter adapter = new CatDogAdapter(dog);
		adapter.pretendCatRun();
	}
}
