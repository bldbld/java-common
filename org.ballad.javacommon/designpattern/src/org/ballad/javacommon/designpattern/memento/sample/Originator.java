package org.ballad.javacommon.designpattern.memento.sample;

/**
 * Memento<br>
 * The OriginatorMemento class like a BackUp of Originator class.
 * 
 * @author Ballad
 * @date 2011-12-02
 */
public class Originator {

	private int value;

	private String str;

	/**
	 * Create a Memento.
	 * 
	 * @return
	 */
	public OriginatorMemento getMemento() {
		return new OriginatorMemento(this);
	}

	/**
	 * Return to a Memento.
	 * 
	 * @param m
	 */
	public void setMemento(OriginatorMemento m) {
		this.value = m.getValue();
		this.str = m.getStr();
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
