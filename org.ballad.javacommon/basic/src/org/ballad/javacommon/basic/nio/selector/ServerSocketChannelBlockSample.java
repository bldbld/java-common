package org.ballad.javacommon.basic.nio.selector;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelBlockSample {

	public static void main(String[] args) {
		
		ServerSocketChannel serverSocketChannel;
		
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				// do something with socketChannel...
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
