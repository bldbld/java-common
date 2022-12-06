package org.ballad.javacommon.algorithms.oj.newcoder.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		while (scr.hasNext()) {

			String input = scr.nextLine().trim();

			String[] inputs = input.split(" ");
			int sums = Integer.valueOf(inputs[0]);

			List<String> allString = new ArrayList<String>();
			Main m = new Main();

			for (int i = 1; i < inputs.length; i++) {
				String str = inputs[i];
				if (str.length() == 8) {
					allString.add(str);
				} else if (str.length() < 8) {
					allString.add(m.addZero(str));
				} else {
					StringBuilder sbdr = new StringBuilder();
					for (int j = 0; j < str.length(); j++) {
						sbdr.append(str.charAt(j));
						if (j != 0 && (j + 1) % 8 == 0) {
							allString.add(sbdr.toString());
							sbdr = new StringBuilder();
						}

					}
					if (sbdr.length() > 0) {
						allString.add(m.addZero(sbdr.toString()));
					}
				}
			}

			String[] dataarr = new String[allString.size()];
			for (int i = 0; i < allString.size(); i++) {
				dataarr[i] = allString.get(i);
			}

			for (int i = 0; i < dataarr.length; i++) {
				for (int j = i + 1; j < dataarr.length; j++) {
					if (dataarr[i].compareTo(dataarr[j]) > 0) {
						String temp = dataarr[i];
						dataarr[i] = dataarr[j];
						dataarr[j] = temp;
					}

				}
			}
			for (int i = 0; i < dataarr.length; i++) {
				String s = dataarr[i];
				if (i == dataarr.length - 1) {
					System.out.print(s);
				} else {
					System.out.print(s + " ");
				}

			}
			System.out.println();
		}

	}

	public String addZero(String str) {
		int length = 8 - str.length();
		StringBuilder sbdr = new StringBuilder();
		sbdr.append(str);
		for (int j = 0; j < length; j++) {
			sbdr.append('0');
		}
		return sbdr.toString();
	}

}
