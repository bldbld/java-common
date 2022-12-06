package org.ballad.javacommon.designpattern.memento.sample;

public class OriginatorMemento {
	
	private int value;

	private String str;

	public OriginatorMemento(Originator o) {
		this.value = o.getValue();
		this.str = o.getStr();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
