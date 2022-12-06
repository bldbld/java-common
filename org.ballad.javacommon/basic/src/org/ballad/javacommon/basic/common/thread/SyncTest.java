package org.ballad.javacommon.basic.common.thread;

public class SyncTest extends Thread{
	public void run (){
		Data.increData();
	}
	public static void main (String [] args){
		SyncTest [] st  = new SyncTest[5];
		for (int i = 0;i<5;i++){
			st[i] = new SyncTest ();
			st[i].start();
			
			System.out.println(Data.data);
		}
	}

}

class Data {
	public static int data = 0;
	public static synchronized void increData (){
		data ++;
	}
	public static int getData (){
		return data;
	}
}
