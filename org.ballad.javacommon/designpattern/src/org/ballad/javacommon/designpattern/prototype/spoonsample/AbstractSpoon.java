package org.ballad.javacommon.designpattern.prototype.spoonsample;

public abstract class AbstractSpoon implements Cloneable {

	String spoonName;

	public String getSpoonName() {
		return spoonName;
	}

	public void setSpoonName(String spoonName) {
		this.spoonName = spoonName;
	}

	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return object;
	}
}
