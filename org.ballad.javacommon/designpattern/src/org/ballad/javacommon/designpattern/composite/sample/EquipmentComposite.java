package org.ballad.javacommon.designpattern.composite.sample;

import java.util.Iterator;
import java.util.List;

public class EquipmentComposite implements Equipment, Iterable<Equipment> {

	public List<Equipment> list;

	@Override
	public boolean add(Equipment equipment) {
		return list.add(equipment);
	}

	@Override
	public double getPrice() {
		return 0;
	}

	@Override
	public boolean remove(Equipment equipment) {
		return list.remove(equipment);
	}

	@Override
	public Iterator<Equipment> iterator() {
		return list.iterator();
	}

}
