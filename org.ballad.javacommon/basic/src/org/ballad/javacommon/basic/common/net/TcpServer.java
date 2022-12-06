package org.ballad.javacommon.basic.common.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServer {
	private ServerSocket socket;

	public TcpServer(int port) {
		try {
			socket = new ServerSocket(port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while (true) {
				Socket conn = socket.accept();
				final Socket connFlnal = conn;
				new Thread() {
					public void run() {
						InputStream is;
						try {
							is = connFlnal.getInputStream();
							byte[] buf = new byte[1024];
							int len = 0;
							while (len >= 0) {
								len = is.read(buf);
								if (len >= 0) {
									System.out.println(new String(buf, 0, len));
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TcpServer ts = new TcpServer(6767);
		ts.run();
	}
}
