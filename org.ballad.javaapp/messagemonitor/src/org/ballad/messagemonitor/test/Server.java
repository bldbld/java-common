package org.ballad.messagemonitor.test;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Run this file separately before the MainFrame to test.
 * 
 * @author Lei Shang
 */
public class Server {

	public static void main(String[] a) throws Exception {
		boolean flag = false;
		// 同一时刻只接受2个连接（第2个放在队列中等待）,真实情况是只接受一个
		ServerSocket ss = new ServerSocket(6666, 1);
		while (true) {
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			String msg = "Ncp Send Message To Mcu:  nMcuAdrs=0x 10301 CmdCode = 0x11ab,lParamLen = 0x12.\n"
					+ "--------- NCP TO MCU ---------- The Content of Message Buffer is: \n"
					+ " 01  03  01  01  12  01  ff  ff  ff  fe  ff  ff  ff  fe  11  ab  fe  01  fe  fe  00  00  00  12  00  01\n"
					+ "01  12  01  fe  fe  fe  00  01  00  01  02  02  fe  fe  fe  fe  fe  fe\n"
					+ "Set the(slot:3 port:1) device type:ETHERNET\n";

			byte[] b = msg.getBytes("US-ASCII");
			try {
				while (true)// for(int i=0;i<10;i++)
				{
					os.write(b);
					os.flush();
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			s.close();
		}

	}

}
