package org.ballad.javacommon.basic.nio.socket;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * 
 * SocketClientSampleNIO.java
 * 
 * ServerInfo:
 * @see ballad.sample.httpServer.core.HttpServer
 * 
 * @author ballad
 * @version 2018
 *
 */
public class SocketClientSampleNIO {

	private static String ServerIP = "localhost";

	private static int ServerPort = 8888;

	/**
	 * 根据文件名下载文件
	 * 
	 * @param msg
	 *            文件名
	 * @return 文件内容，若不存在返回null
	 */
	public static byte[] download(String msg) {
		byte[] bytes = null;
		try {
			Socket socket = new Socket(ServerIP, ServerPort);
			OutputStream os = socket.getOutputStream();
			os.write(msg.getBytes());
			socket.shutdownOutput();

			InputStream is = socket.getInputStream();
			/*
			 * NIO Channel
			 */
			ReadableByteChannel rbc = Channels.newChannel(is);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			while ((len = rbc.read(byteBuffer)) != -1) {
				bos.write(byteBuffer.array(), 0, len);
				byteBuffer.flip();
			}
			bytes = bos.toByteArray();
			
			// System.out.println(new String(bytes));
			
			byteBuffer.clear();
			rbc.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}

	public static void main(String[] args) {
		SocketClientSampleNIO.download("index.html");
	}
}
