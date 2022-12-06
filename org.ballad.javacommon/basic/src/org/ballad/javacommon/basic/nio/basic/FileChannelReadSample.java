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
				// ͨ��flip()������Buffer��дģʽ�л�����ģʽ
				// �����ڲ�ָ��
				buf.flip();

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}

				// �����ַ�ʽ����ջ�����������clear()��compact()������
				// clear()���������������������
				// compact()����ֻ������Ѿ����������ݡ��κ�δ�������ݶ����Ƶ�����������ʼ������д������ݽ��ŵ�������δ�����ݵĺ��档
				buf.clear();
				bytesRead = inChannel.read(buf);
			}
			aFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
