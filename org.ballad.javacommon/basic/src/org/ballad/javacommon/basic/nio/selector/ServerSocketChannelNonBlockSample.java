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

				// ServerSocketChannel可以设置成非阻塞模式。在非阻塞模式下，accept()
				// 方法会立刻返回，如果还没有新进来的连接,返回的将是null。
				// 因此，需要检查返回的SocketChannel是否是null.
				
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
