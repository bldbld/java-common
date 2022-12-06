package org.ballad.httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServer {
	/**
	 * 一个基本的HTTP 服务器 
	 * 可对请求返回 website下的文件
	 * 
	 */
	private ServerSocket socket;

	public HttpServer(int port) {
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
				final Socket connFinal = conn;
				new Thread() {
					public void run() {
						try {
							BufferedReader in = new BufferedReader(
									new InputStreamReader(connFinal
											.getInputStream()));
							String request = in.readLine();
							System.out.println("The request is " + request);
							PrintWriter out = new PrintWriter(connFinal
									.getOutputStream(), true);
							out.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
							out.println("Content-Type:text/html;charset=GBK");
							out.println();// 根据 HTTP 协议, 空行将结束头信息
							
							File f = new File ("website/index.html");
							StringBuilder sb = new StringBuilder();
							String tmp ;
							BufferedReader br = new BufferedReader (new FileReader(f));
							while (true){
								tmp = br.readLine();
								if (tmp==null){
									break;
								}else {
									sb.append(tmp+"\r\n");
								}
							}
							out.println(sb.toString());
							out.close();
							br.close();
//							out.println("<h1> Hello Http Server</h1>");
//							out.close();
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
		HttpServer ts = new HttpServer(8888);
		ts.run();
	}
}
