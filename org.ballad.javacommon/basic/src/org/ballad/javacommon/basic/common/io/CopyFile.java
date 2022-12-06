package org.ballad.javacommon.basic.common.io;

import java.io.*;
import java.util.ArrayList;

public class CopyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static ArrayList<String> readByBufferedReader(String fileName) {
		File f = new File(fileName);
		ArrayList<String> array = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String buff;
			while (true) {
				buff = br.readLine();
				if (buff == null) {
					break;
				} else {
					array.add(buff);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;
	}

	public static void readByByte(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(f);
			byte[] buf = new byte[1024];
			int len = 0;
			do {
				len = fis.read(buf, 0, buf.length);
				System.out.println(new String(buf, 0, len));
			} while (len >= 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readByInputStream(String fileName) {
		File f = new File(fileName);
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(new FileInputStream(f));
			BufferedReader bf = new BufferedReader(isr);

			/* 下面的方法同readByBuffered */

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
