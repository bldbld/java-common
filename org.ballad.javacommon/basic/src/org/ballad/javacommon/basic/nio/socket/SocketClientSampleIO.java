package org.ballad.javacommon.basic.nio.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * SocketClientSampleIO.java<br>
 * 
 * ServerInfo:
 * @see ballad.sample.httpServer.core.HttpServer
 * 
 * @author ballad
 * @version 2018
 *
 */
public class SocketClientSampleIO {

	private static String ServerIP = "localhost";

	private static int ServerPort = 8888;

	/**
	 * �����ļ��������ļ�
	 * 
	 * @param msg
	 *            �ļ���
	 * @return �ļ����ݣ��������ڷ���null
	 */
	public static byte[] download(String msg) {
		byte[] bytes = null;
		try {
			Socket socket = new Socket(ServerIP, ServerPort);
			OutputStream os = socket.getOutputStream();
			os.write(msg.getBytes());
			socket.shutdownOutput();

			InputStream is = socket.getInputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = is.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.close();
			bytes = bos.toByteArray();
			System.out.println(new String(bytes));

			bos.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;
	}

	public static void main(String[] args) {
		SocketClientSampleIO.download("index.html");
	}
}
