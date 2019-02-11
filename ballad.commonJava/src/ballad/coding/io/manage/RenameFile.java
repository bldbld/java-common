package ballad.coding.io.manage;

import java.io.File;

/**
 * 批量重命名文件<br>
 * HUATENG时对NCPS进行批量重命名
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
