package org.ballad.javacommon.designpattern.adapter.pegsample;

/**
 * Adapter<br>
 * The class "PegAdatper" is the Adapter, and the class "RoundPeg" is the
 * Adaptee.<br>
 * The class PegAdapter can use both "RoundPeg" and "SquarePeg"'s methods.<br>
 * We also can use interfaces to finish duplicate "inherited".
 * 
 * @author Ballad
 * @date 2011-12-01
 */
public class PegAdapter extends SquarePeg {

	private RoundPeg roundPeg;

	public void insertRound() {
		this.roundPeg.insertRound();
	}
}
