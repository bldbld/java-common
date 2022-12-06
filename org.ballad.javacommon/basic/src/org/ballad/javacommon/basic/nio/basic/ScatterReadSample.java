package org.ballad.javacommon.basic.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterReadSample {

	public static void main(String[] args) {
		try {
			RandomAccessFile aFile = new RandomAccessFile("readdata.txt", "rw");
			FileChannel inChannel = aFile.getChannel();
			ByteBuffer bufHead = ByteBuffer.allocate(8);
			ByteBuffer bufBody = ByteBuffer.allocate(18);
			ByteBuffer[] bufs = { bufHead, bufBody };
			long bytesRead = inChannel.read(bufs);
			while (bytesRead != -1) {

				System.out.println("Read " + bytesRead);

				bufs[0].flip();
				while (bufs[0].hasRemaining()) {
					System.out.print((char) bufs[0].get());
				}

				bufs[1].flip();
				while (bufs[1].hasRemaining()) {
					System.out.print((char) bufs[1].get());
				}

				bufs[0].clear();
				bufs[1].clear();
				bytesRead = inChannel.read(bufs);
			}
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
