package org.ballad.javacommon.algorithms.netprotocols.bellovinmerrit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	/**
	 * 下面这段代码是测试DES加密文本文件的。模拟协议的过程的测试代码详见报告。
	 */
	public static void main(String[] args) {
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yy-MM-dd-HH-mm-ssssss");
		DesEncrypt des = new DesEncrypt();
		des.getKey("DESTESTFILE");
		try {
			now = new java.util.Date();
			System.out.println(formatter.format(now));
			FileWriter fw = new FileWriter("desstore.txt");
			FileReader fr = new FileReader("destest.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			String fordes;
			while (str != null) {
				fordes = des.getEncString(str);
				fw.write(fordes);
				fw.write("\r\n");
				fw.flush();
				str = br.readLine();
			}
			fw.close();
			br.close();
			fr.close();
		} catch (Exception e) {
		}
		now = new java.util.Date();
		System.out.println(formatter.format(now));
		try {
			FileWriter fw = new FileWriter("destest2.txt");
			FileReader fr = new FileReader("desstore.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			String fordes;
			while (str != null) {
				fordes = des.getDesString(str);
				fw.write(fordes);
				fw.write("\r\n");
				fw.flush();
				str = br.readLine();
			}
			fw.close();
			br.close();
			fr.close();
			now = new java.util.Date();
			System.out.println(formatter.format(now));
		} catch (Exception e) {
		}

	}
}
