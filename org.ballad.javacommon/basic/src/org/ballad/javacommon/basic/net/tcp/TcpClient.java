package org.ballad.javacommon.basic.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	private Socket socket;

	/**
	 * @param args
	 */
	public TcpClient(String url, int port) {
		try {
			socket = new Socket(url, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String msg) {
		try {
			OutputStream os = socket.getOutputStream();
			os.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TcpClient tc = new TcpClient("localhost", 6767);
		tc.write("Hello tcp");
		tc.closeSocket();
	}
}
