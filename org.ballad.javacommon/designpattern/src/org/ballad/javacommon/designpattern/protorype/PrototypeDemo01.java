package org.ballad.javacommon.designpattern.protorype;

/**
 * һ��������ʹ��Prototypeģʽ��ʾ��,������Ϊ����
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
 * ���ӳ�����
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
 * ������
 */
class SoupSpoon extends Spoon {
	public SoupSpoon() {
		setSpoonName("Soup Spoon");
	}
}

/**
 * ɫ��������
 */
class SaladSpoon extends Spoon {
	public SaladSpoon() {
		setSpoonName("Salad Spoon");
	}
}