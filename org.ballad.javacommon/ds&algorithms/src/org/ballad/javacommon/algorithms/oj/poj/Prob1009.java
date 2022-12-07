/*
 * 2011, BALLAD Java Source File.
 * POJ Codes.
 */
package org.ballad.javacommon.algorithms.oj.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// POJ 1009 Edge Detection
//
// Time Limit: 1000MS		
// Memory Limit: 10000K
// 
// Description
// IONU Satellite Imaging, Inc. records and stores very large images using run 
// length encoding. You are to write a program that reads a compressed image, 
// finds the edges in the image, as described below, and outputs another 
// compressed image of the detected edges.
// A simple edge detection algorithm sets an output pixel's value to be the 
// maximum absolute value of the differences between it and all its surrounding 
// pixels in the input image. Consider the input image below:
// // IMG FILE 1009 //
// The upper left pixel in the output image is the maximum of the values 
// |15-15|,|15-100|, and |15-100|, which is 85. The pixel in the 4th row, 
// 2nd column is computed as the maximum of |175-100|, |175-100|, |175-100|, 
// |175-175|, |175-25|, |175-175|,|175-175|, and |175-25|, which is 150.
// Images contain 2 to 1,000,000,000 (10^9) pixels. All images are encoded 
// using run length encoding (RLE). This is a sequence of pairs, containing 
// pixel value (0-255) and run length (1-10^9). Input images have at most 1,000 
// of these pairs. Successive pairs have different pixel values. All lines in 
// an image contain the same number of pixels.
// 
// Input
// Input consists of information for one or more images. Each image starts 
// with the width, in pixels, of each image line. This is followed by the RLE 
// pairs, one pair per line. A line with 0 0 indicates the end of the data 
// for that image. An image width of 0 indicates there are no more images to 
// process. The first image in the example input encodes the 5x7 input image 
// above.
// 
// Output
// Output is a series of edge-detected images, in the same format as the 
// input images, except that there may be more than 1,000 RLE pairs.
// 
// Sample Input
// 7
// 15 4
// 100 15
// 25 2
// 175 2
// 25 5
// 175 2
// 25 5
// 0 0
// 10
// 35 500000000
// 200 500000000
// 0 0
// 3
// 255 1
// 10 1
// 255 2
// 10 1
// 255 2
// 10 1
// 255 1
// 0 0
// 0
// 
// Sample Output
// 7
// 85 5
// 0 2
// 85 5
// 75 10
// 150 2
// 75 3
// 0 2
// 150 2
// 0 4
// 0 0
// 10
// 0 499999990
// 165 20
// 0 499999990
// 0 0
// 3
// 245 9
// 0 0
// 0
// 
// Hint
// A brute force solution that attempts to compute an output value for every 
// individual pixel will likely fail due to space or time constraints. 
//
// Algorithm Description:
// 由于点的数目非常大，最大可能为10^9，所以无法对全部点进行遍历。
// 通过在输入数据时，把一些重要的点的相关信息记录起来，然后只对这些点进行处理。
// 每一组RLE输入后，都记录下一个点，定义为影响点，
// (影响点取下一组RLE的第一个点)
// 通过分析得出：
//  1.该影响点会影响周围8个点及自己的计算结果；
//  2.该影响点会影响下一行第一个点的计算结果。
// 第2条的原因是，对于下一行第一个点来说，
// 如果上一行有影响点，则它的计算结果很有可能不同于前一个点的计算结果，
// 情况如下所示：
// 15  15  15  15  15  100 100
// 100 100 100 100 100 100 100
// ( ！！！！！！！对于是否局限只存在第一行和第二行，还不能确定，估计是 ！！！！！！！)
// 左下面的点的计算结果将不同于右上角的点的计算结果。
// 对于这些会被影响的点，它们的计算结果有可能不同于前面的点，
// 所以这些要对这些点重新计算，而对于其余不受影响的点，则可以直接取它前面点的结果。
// 于是，计算的复杂度将依赖于RLE的组数(不超过1000)，而不是可能达到10^9的坐标点数。
//
// 

public class Prob1009 {
	public static Object javain(String flag) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			in.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 图像坐标的宽度
	private int width;
	// 图像坐标点总数
	private int total;

	public void run() {
		width = 0;
		total = 0;

		if (width == 0 && total == 0) {
			// 输入0 0表示本次输入结束
			return;
		}
		if (width == 0 && total == 0) {
			// 输入0 0表示本次输入结束
			return;
		}

	}

	public static void main(String[] args) {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 new BufferedReader(new InputStreamReader(System.in));

	}

}
