package org.ballad.javacommon.basic.concurrency.thread;

public class ThreadTest extends Thread {
	public ThreadTest(String threadName) {
        super(threadName);
    }
 
    public void run() {
        System.out.println(getName() + " �߳����п�ʼ!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " �߳����н���!");
    }
    
    public static void main (String [] args){
		ThreadTest[] tt = new ThreadTest[10];
		for (int i = 0;i<10;i++){
			tt[i] = new ThreadTest(new Integer(i).toString());
			tt[i].start();
		}
	}
}
