package org.ballad.javacommon.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteSample {

	public static void main(String[] args) {

		try {
			int i = 0;
			// FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下。
			RandomAccessFile aFile = new RandomAccessFile("writedata.txt", "rw");
			FileChannel outChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(8);

			buf.clear();
			buf.put("12345678".getBytes());
			buf.flip();

			while (buf.hasRemaining()) {

				outChannel.write(buf);
				System.out.println("write a buf ");

				buf.clear();
				buf.put("12345678".getBytes());
				buf.flip();

				if (i >= 3) {
					break;
				}
				i++;
			}
			outChannel.close();
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
