package org.ballad.javacommon.basic.common.io.manage;

import java.io.File;

/**
 * �����������ļ�<br>
 * HUATENGʱ��NCPS��������������
 * 
 * @author ballad
 * @version 2011/02/15
 */
public class RenameFile {

	public static void main(String[] args) {
		// DEMO
		String dirName = "20101028";
		File dir = new File(dirName);
		File[] files = dir.listFiles();
		String fileName = null;
		for (int i = 0; i < files.length; i++) {
			fileName = files[i].getName();
			if (fileName.startsWith("S")) {
				files[i].renameTo(new File("Ncps"
						+ fileName.substring(3, fileName.length())));
			}
		}
	}

}
