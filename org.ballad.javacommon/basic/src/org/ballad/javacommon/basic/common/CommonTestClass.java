package org.ballad.javacommon.basic.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommonTestClass {

	void changeParam(String param) {
		param = "def";
	}

	void changeParam(List<String> param) {
		param = new ArrayList<String>();
	}

	void addToParam(List<String> param) {
		param.add("def");
	}

	void run() {
		// String param = "abc";
		// changeParam(param);
		// System.out.println(param);

		// List<String> param = new ArrayList<String> (); // ��Ҫ�ƽ�������﷨����
		// param.add("abc");
		// changeParam(param);
		// System.out.println(param); // �������
		//
		List<String> param = new ArrayList<String>(); // ��Ҫ�ƽ�������﷨����
		param.add("abc");
		addToParam(param);
		System.out.println(param); // һ
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		short s = 1;
		float f = 3.4f;
		Integer i;
		System.out.println (s);
		// File f = new File ("123.txt");
		// f.createNewFile();
		// System.out.println (f.getAbsolutePath());
		
	}
}
