package org.ballad.javacommon.basic.common.socket.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClinet {
	public static void main (String [] args){
		try {
			String hostname = "localhost";
			int port = 80;
			Socket socket = new Socket(hostname,port);
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true); 
			InputStream inputStream = socket.getInputStream();
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));

			int c;
			String s = new String();
			while ((s=line.readLine())!=null){
				System.out.println(s);
			}
		}catch (Exception e){
			
		}
	}
}
