package org.ballad.javacommon.basic.nio.selector;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelNonBlockSample {

	public static void main(String[] args) {

		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			serverSocketChannel.configureBlocking(false);
			while (true) {

				// ServerSocketChannel�������óɷ�����ģʽ���ڷ�����ģʽ�£�accept()
				// ���������̷��أ������û���½���������,���صĽ���null��
				// ��ˣ���Ҫ��鷵�ص�SocketChannel�Ƿ���null.
				
				SocketChannel socketChannel = serverSocketChannel.accept();

				if (socketChannel != null) {
					// do something with socketChannel...
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
