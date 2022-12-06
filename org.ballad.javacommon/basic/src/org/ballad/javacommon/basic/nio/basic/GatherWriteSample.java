package org.ballad.javacommon.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class GatherWriteSample {

	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("writedata.txt", "rw");
			FileChannel inChannel = aFile.getChannel();

			ByteBuffer bufHead = Charset.forName("utf8").encode("你好你好你好你好你好");
			ByteBuffer bufBody = Charset.forName("utf8").encode("abcdefghijklmnopqrstuvwxyz");
			ByteBuffer[] bufs = { bufHead, bufBody, bufHead };

			inChannel.write(bufs);

			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
