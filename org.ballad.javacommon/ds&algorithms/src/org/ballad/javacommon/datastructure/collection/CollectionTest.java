package org.ballad.javacommon.datastructure.collection;

public class CollectionTest {
	public static void main(String[] args) {
		// CollectionTest.queueTest();
		CollectionTest.linkedListTest();

	}

	public static void queueTest() {
		Queue<Integer> queue = new Queue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(6);
		System.out.println(queue.getFront());
		System.out.println(queue.size());
		System.out.println(queue.pollFront());
		System.out.println(queue.pollFront());
		System.out.println(queue.size());
	}

	public static void linkedListTest() {
		LinkedList<String> list = new LinkedList<String>("Red2");
		list.insert("CS", 1);
		list.insert("NFS", 1);
		list.insert("AOE", 4);
		list.remove(4);
		System.out.println(list.length);
		list.showList();
	}
}
