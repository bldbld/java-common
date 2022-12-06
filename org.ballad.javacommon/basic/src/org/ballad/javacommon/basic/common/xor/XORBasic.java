package org.ballad.javacommon.basic.common.xor;

/**
 * 异或的基本信息
 * <p>
 * 异或，英文为exclusive OR，或缩写成xor。
 * </p>
 * <p>
 * a⊕b = (¬a ∧ b) ∨ (a ∧¬b)
 * </p>
 * <p>
 * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
 * </p>
 * 
 * @author ballad
 * 
 */
public class XORBasic {

	public static void main(String[] args) {
		System.out.println(1 ^ 1); // expected : 0
		System.out.println(1 ^ 2); // expected : 3
	}
}