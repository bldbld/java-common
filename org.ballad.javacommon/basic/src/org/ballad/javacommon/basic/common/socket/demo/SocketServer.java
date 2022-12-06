package org.ballad.javacommon.basic.common.socket.demo;

import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main (String [] args){
		try {
			ServerSocket server = new ServerSocket(4321);

			while (true){
				System.out.println(1);
				Socket conn = server.accept();
				OutputStreamWriter out = new OutputStreamWriter (conn.getOutputStream());
				out.write("Hello");
		
			}
			
		}catch (Exception e){
			
		}
		
	}
}