package org.ballad.javacommon.basic.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

	/**
	 * @param args
	 */
	private DatagramSocket socket;

	public UdpServer(int port) {
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		if (socket.isBound()) {
			while (true) {
				byte[] buff = new byte[1024];
				DatagramPacket packet = new DatagramPacket(buff, buff.length);
				try {
					socket.receive(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
				int len = packet.getLength();
				if (len >= 0) {
					System.out.println(new String(buff, 0, len));
				}
			}
		} else {
			System.err.println("UDP Server Not Bounded");
		}
	}

	public static void main(String[] args) {

	}
}
