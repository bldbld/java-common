package org.ballad.javacommon.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadSample {

	public static void main(String[] args) {

		try {
			RandomAccessFile aFile = new RandomAccessFile("readdata.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {

				System.out.println("Read " + bytesRead);
				// 通过flip()方法将Buffer从写模式切换到读模式
				// 重置内部指针
				buf.flip();

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}

				// 有两种方式能清空缓冲区：调用clear()或compact()方法。
				// clear()方法会清空整个缓冲区。
				// compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
