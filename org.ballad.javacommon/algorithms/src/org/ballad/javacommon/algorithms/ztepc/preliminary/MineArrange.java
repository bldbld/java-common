package org.ballad.javacommon.algorithms.ztepc.preliminary;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 中兴捧月程序设计大赛 -- 一个 10*10 布雷程序
 * 
 * @author ballad
 */
public class MineArrange {

	private final int[][] mineMap;
	private final Set<Integer> mines;

	public MineArrange() {
		mineMap = new int[12][12];
		// generate the mine location
		mines = new HashSet<Integer>();
		Random r = new Random();
		int ri;
		while (mines.size() < 10) {
			ri = r.nextInt(99);
			mines.add(ri);
		}
		// init the mine map
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (mines.contains(i * 10 + j - 11)) {
					mineMap[i][j] = -1;
				} else {
					mineMap[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (mineMap[i][j] == -1) {
					for (int k = i - 1; k <= i + 1; k++) {
						for (int m = j - 1; m <= j + 1; m++) {
							if (mineMap[k][m] != -1) {
								mineMap[k][m]++;
							}
						}
					}
				}
			}
		}
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (mineMap[i][j] == -1) {
					System.out.print("  " + mineMap[i][j]);
				} else {
					System.out.print("   " + mineMap[i][j]);
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		MineArrange ma = new MineArrange();
	}

}
