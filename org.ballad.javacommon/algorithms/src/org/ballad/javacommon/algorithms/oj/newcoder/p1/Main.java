package org.ballad.javacommon.algorithms.oj.newcoder.p1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String workers = scr.nextLine().trim();
		while (scr.hasNext()) {

			List<Main> datas = new ArrayList<Main>();
			Set<String> fruitList = new LinkedHashSet<String>();
			while (scr.hasNext()) {
				String input = scr.nextLine();
				if (!input.contains(" ")) {
					break;
				}
				String[] inputs = input.split(" ");
				Main m = new Main();
				m.type = inputs[0];
				m.work_id = Integer.valueOf(inputs[1]);
				m.heave = Integer.valueOf(inputs[2]);
				fruitList.add(m.type);
				datas.add(m);

				
			}
			
			List<String> frutList = new ArrayList<String>();
			for (String frut : fruitList ) {
				frutList.add(frut);
			}
			
			Main [] dataarr = new Main [datas.size()];
			for (int i = 0; i < datas.size(); i++ ) {
				dataarr[i] = datas.get(i);
			}

			for (int i = 0; i < dataarr.length; i++) {
				for (int j = i + 1; j < dataarr.length; j++) {
					if (dataarr[i].compare(frutList, dataarr[j])) {
						Main temp =  dataarr[i];
						dataarr[i] = dataarr[j];
						dataarr[j] = temp;
					}

				}
			}

			for (int i = 0; i < dataarr.length; i++) {
				Main m1 = dataarr[i];
				System.out.print(m1.type + " " + m1.work_id + " " + m1.heave);
				System.out.println();
			}
		}
	}

	String type;
	int work_id;
	int heave;

	public boolean compare(List<String> fruitList, Main to) {
		if (fruitList.indexOf(this.type) > fruitList.indexOf(to.type)) {
			return true;
		} else if (fruitList.indexOf(this.type) < fruitList.indexOf(to.type)) {
			return false;
		} else {
			if (this.heave > to.heave) {
				return true;
			} else if (this.heave < to.heave) {
				return false;
			} else {
				if (this.work_id > to.work_id) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

}
