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
			// ��ʼ��
			SocketChannel inChannel = SocketChannel.open();
			inChannel.connect(new InetSocketAddress("http://localhost", 80));

			// Non block
			inChannel.configureBlocking(false);
			Selector selector = Selector.open();

			// ע��
			SelectionKey key = inChannel.register(selector, SelectionKey.OP_READ);
			// interest����������ѡ��ĸ���Ȥ���¼����� �á�λ�롱����
			int interestSet = key.interestOps();
			// ready ������ͨ���Ѿ�׼�������Ĳ����ļ��ϡ���һ��ѡ��(Selection)֮��������ȷ������ready set
			int readySet = key.readyOps();

			while (true) {
				// ������������һ��ͨ������ע����¼��Ͼ����ˡ�
				int readyChannels = selector.select();
				if (readyChannels == 0) {
					continue;
				}
				// һ��������select()���������ҷ���ֵ������һ��������ͨ�������ˣ�
				// Ȼ�����ͨ������selector��selectedKeys()���������ʡ���ѡ�������selected key
				// set�����еľ���ͨ����
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
			 * ĳ���̵߳���select()�����������ˣ���ʹû��ͨ���Ѿ�������Ҳ�а취�����select()�������ء�
			 * ֻҪ�������߳��ڵ�һ���̵߳���select()�������Ǹ������ϵ���Selector.wakeup()�������ɡ�������select(
			 * )�����ϵ��̻߳������ء�
			 * ����������̵߳�����wakeup()����������ǰû���߳�������select()�����ϣ��¸�����select()�������̻߳�������
			 * ������wake up������
			 */
			// selector.wakeup();

			// ����Selector�������close()������رո�Selector����ʹע�ᵽ��Selector�ϵ�����SelectionKeyʵ����Ч��ͨ����������رա�
			// selector.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
