package ballad.dive.designpattern.composite.sample;

public interface Equipment {
	// public boolean hasNext ();
	public double getPrice();

	public boolean add(Equipment equipment);

	public boolean remove(Equipment equipment);
}
