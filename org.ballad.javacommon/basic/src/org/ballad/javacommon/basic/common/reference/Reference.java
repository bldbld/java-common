package org.ballad.javacommon.basic.common.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * 本Java类用于加深对Java引用模式的理解。
 * <p>
 * 代码出处：水木社区 → Java技术 → 看来不了解“引用”的人不少，作者提出的一道面试题。
 * </p>
 * <p>
 * 值传递：方法调用时，实际参数把它的值传递给对应的形式参数，方法执行中形式参数值的改变不影响实际参 数的值。
 * </p>
 * <p>
 * 引用传递：也称为传地址。方法调用时，实际参数的引用(地址，而不是参数的值)被传递给方法中相对应的形式参数，在方法执行中，
 * 对形式参数的操作实际上就是对实际参数的操作 ，方法执行中形式参数值的改变将会影响实际参数的值。
 * </p>
 * 
 * @author GUSSET
 * @date 02/18/2011
 */
public class Reference {

	public void changeParam(String param) {
		param = "def";
	}

	public void changeParam(List<String> param) {
		param = new ArrayList<String>();
	}

	public void addToParam(List<String> param) {
		param.add("def");
	}

	public void run() {
		/*
		 * Actual Output:abc
		 */
		String param1 = "abc";
		changeParam(param1);
		System.out.println(param1);

		/*
		 * Actual Output:[abc]
		 */
		List<String> param2 = new ArrayList<String>();
		param2.add("abc");
		changeParam(param2);
		System.out.println(param2);

		/*
		 * Actual Output:[abc,def]
		 */
		List<String> param3 = new ArrayList<String>();
		param3.add("abc");
		addToParam(param3);
		System.out.println(param3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reference refTester = new Reference();
		refTester.run();
	}
}
