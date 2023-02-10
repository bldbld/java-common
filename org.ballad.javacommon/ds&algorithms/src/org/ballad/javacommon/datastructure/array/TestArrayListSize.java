package org.ballad.javacommon.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Testing for size.
 * 
 * @version 2012-10-23
 * @author Ballad
 * 
 */
public class TestArrayListSize {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(5);
		list1.add("valueA");
		list1.add("valueB");

		// 在此处增加断点，会显示出list1的elementData数组为5
		System.out.println(list1.size());
	}
}
