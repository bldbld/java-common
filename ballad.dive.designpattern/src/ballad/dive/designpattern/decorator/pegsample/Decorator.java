package ballad.dive.designpattern.decorator.pegsample;

import java.util.ArrayList;
import java.util.List;

/**
 * Decorator
 * 
 * @author Ballad
 * @DATE 2011-12-02
 */
public class Decorator implements Work {

	// The Basic Work
	private Work work;

	// The Decorator Works, it can be dynamic generated.
	private List<Work> othersWork;

	public Decorator(Work work) {
		this.work = work;
		othersWork = new ArrayList<Work>();
	}

	@Override
	public void insert() {
		work.insert();
	}

	public void runMethod(int i) {
		Work oWork = othersWork.get(i);
		oWork.insert();
	}

}
