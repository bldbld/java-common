package org.ballad.javacommon.datastructure.test;

import java.util.Set;
import java.util.TreeSet;

public class DsTest {

	public static void main (String [] args){
		DsTest.TreeSet();
	}
	public static void TreeSet (){
		Set<String > s = new TreeSet<String > ();
		s.add("VigosS");
		s.add("KuroKy");
		s.add("Loda");
		s.add("Misery");
		System.out.println(s.toString());
	}
}
