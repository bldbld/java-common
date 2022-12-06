package org.ballad.javacommon.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTransferFromSample {

	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("readdata.txt", "r");
			FileChannel inChannel = aFile.getChannel();

			RandomAccessFile bFile = new RandomAccessFile("writedata.txt", "rw");
			FileChannel outChannel = bFile.getChannel();

			long position = 0;
			long count = inChannel.size();

			outChannel.transferFrom(inChannel, position, count);

			// 同样可以用
			// transferTo()

			aFile.close();
			bFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
