package org.ballad.javacommon.basic.concurrency.thread;

public class ThreadTest extends Thread {
	public ThreadTest(String threadName) {
        super(threadName);
    }
 
    public void run() {
        System.out.println(getName() + " 线程运行开始!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " 线程运行结束!");
    }
    
    public static void main (String [] args){
		ThreadTest[] tt = new ThreadTest[10];
		for (int i = 0;i<10;i++){
			tt[i] = new ThreadTest(new Integer(i).toString());
			tt[i].start();
		}
	}
}
