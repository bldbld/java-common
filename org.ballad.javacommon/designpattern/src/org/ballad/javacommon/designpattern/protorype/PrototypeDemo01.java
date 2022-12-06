package org.ballad.javacommon.designpattern.protorype;

/**
 * 一个基本的使用Prototype模式的示例,以勺子为例。
 * 
 * @author Ballad
 * @version 0.1 02/22/2011
 */
public class PrototypeDemo01 {
	public static void main(String[] args) {
		SoupSpoon soupSpoon = new SoupSpoon();
		SaladSpoon saladSpoon = new SaladSpoon();

		Spoon spoonT1 = (Spoon) soupSpoon.clone();
		System.out.println(spoonT1.getSpoonName());

		Spoon spoonT2 = (Spoon) saladSpoon.clone();
		System.out.println(spoonT2.getSpoonName());
	}
}

/**
 * 勺子抽象类
 */
abstract class Spoon implements Cloneable {
	private String spoonName;

	public String getSpoonName() {
		return spoonName;
	}

	public void setSpoonName(String spoonName) {
		this.spoonName = spoonName;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

/**
 * 汤勺类
 */
class SoupSpoon extends Spoon {
	public SoupSpoon() {
		setSpoonName("Soup Spoon");
	}
}

/**
 * 色拉勺子类
 */
class SaladSpoon extends Spoon {
	public SaladSpoon() {
		setSpoonName("Salad Spoon");
	}
}