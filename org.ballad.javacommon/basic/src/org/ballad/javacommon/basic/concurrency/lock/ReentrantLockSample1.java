package org.ballad.javacommon.basic.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample1 {

	public static void main(String[] args) {

		/**
		 * ReentrantLock 构造器的一个参数是 boolean 值，它允许您选择想要一个 公平（fair）锁，还是一个
		 * 不公平（unfair）锁。公平锁使线程按照请求锁的顺序依次获得锁；<br>
		 * 而不公平锁则允许讨价还价，在这种情况下，线程有时可以比先请求锁的其他线程先得到锁。<br>
		 * 
		 * 为什么我们不让所有的锁都公平呢？毕竟，公平是好事，不公平是不好的，不是吗？（当孩子们想要一个决定时，总会叫嚷“这不公平”。
		 * 我们认为公平非常重要，孩子们也知道。）在现实中，公平保证了锁是非常健壮的锁，有很大的性能成本。
		 * 要确保公平所需要的记帐（bookkeeping）和同步，就意味着被争夺的公平锁要比不公平锁的吞吐率更低。
		 * 作为默认设置，应当把公平设置为false，除非公平对您的算法至关重要，需要严格按照线程排队的顺序对其进行服务。
		 * 
		 * 那么同步又如何呢？内置的监控器锁是公平的吗？答案令许多人感到大吃一惊，它们是不公平的，而且永远都是不公平的。
		 * 但是没有人抱怨过线程饥渴，因为 JVM 保证了所有线程最终都会得到它们所等候的锁。
		 * 确保统计上的公平性，对多数情况来说，这就已经足够了，而这花费的成本则要比绝对的公平保证的低得多。
		 * 所以，默认情况下  ReentrantLock 是“不公平”的，这一事实只是把同步中一直是事件的东西表面化而已。
		 * 如果您在同步的时候并不介意这一点，那么在 ReentrantLock 时也不必为它担心。
		 */
		Lock lock = new ReentrantLock(false);
		lock.lock();
		try {
			if(lock.tryLock()){
				System.out.println("Get Lock");
			}
			// update object state
		} finally {
			lock.unlock();
		}
	}
}
