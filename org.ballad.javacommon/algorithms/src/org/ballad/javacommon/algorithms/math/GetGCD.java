package org.ballad.javacommon.algorithms.math;

/**
 * Greatest Common Divisor 最大公约数
 *
 * @author BLDBLD
 */
public class GetGCD {
	static int gcd(int n, int m) {
		while (n != m) {
			if (n > m)
				n -= m;
			else
				m -= n;
		}
		return n;
	}

	public static void main(String[] args) {
		int n = 1384900;
		int m = 3230656;
		int x = GetGCD.gcd(n, m);
		System.out.println(x);
	}
}
