package org.ballad.javacommon.basic.nio.selector;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorSample {

	public static void main(String[] args) {

		try {
			// 初始化
			SocketChannel inChannel = SocketChannel.open();
			inChannel.connect(new InetSocketAddress("http://localhost", 80));

			// Non block
			inChannel.configureBlocking(false);
			Selector selector = Selector.open();

			// 注册
			SelectionKey key = inChannel.register(selector, SelectionKey.OP_READ);
			// interest集合是你所选择的感兴趣的事件集合 用“位与”操作
			int interestSet = key.interestOps();
			// ready 集合是通道已经准备就绪的操作的集合。在一次选择(Selection)之后，你会首先访问这个ready set
			int readySet = key.readyOps();

			while (true) {
				// 阻塞到至少有一个通道在你注册的事件上就绪了。
				int readyChannels = selector.select();
				if (readyChannels == 0) {
					continue;
				}
				// 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，
				// 然后可以通过调用selector的selectedKeys()方法，访问“已选择键集（selected key
				// set）”中的就绪通道。
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				while (keyIterator.hasNext()) {
					SelectionKey selectedKey = keyIterator.next();
					if (selectedKey.isAcceptable()) {
						// a connection was accepted by a ServerSocketChannel.
					} else if (selectedKey.isConnectable()) {
						// a connection was established with a remote server.
					} else if (selectedKey.isReadable()) {
						// a channel is ready for reading
					} else if (selectedKey.isWritable()) {
						// a channel is ready for writing
					}
					keyIterator.remove();
				}
			}

			/*
			 * 某个线程调用select()方法后阻塞了，即使没有通道已经就绪，也有办法让其从select()方法返回。
			 * 只要让其它线程在第一个线程调用select()方法的那个对象上调用Selector.wakeup()方法即可。阻塞在select(
			 * )方法上的线程会立马返回。
			 * 如果有其它线程调用了wakeup()方法，但当前没有线程阻塞在select()方法上，下个调用select()方法的线程会立即“
			 * 醒来（wake up）”。
			 */
			// selector.wakeup();

			// 用完Selector后调用其close()方法会关闭该Selector，且使注册到该Selector上的所有SelectionKey实例无效。通道本身并不会关闭。
			// selector.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
