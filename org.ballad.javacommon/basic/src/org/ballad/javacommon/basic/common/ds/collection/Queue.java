package org.ballad.javacommon.basic.common.ds.collection;

/**
 * ╤сап
 * 
 * @author ballad
 * @version 2010/04/30 initial
 * @version 2012/04/30 code format
 * 
 * @param <T>
 */
public class Queue<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public Queue() {
		front = null;
		rear = null;
		size = 0;
	}

	public Queue(Node<T> front) {
		this.front = front;
		this.rear = front;
		size = 1;
	}

	public T getFront() {
		return front.elenemt;
	}

	public int size() {
		return this.size;
	}

	public T pollFront() {
		if (front != null) {
			T tmp = front.elenemt;
			front = front.link;
			size--;
			return tmp;
		} else {
			return null;
		}
	}

	public void offer(T element) {
		Node<T> node = new Node<T>(element);
		if (rear == null) {
			front = node;
			rear = node;
		} else {
			rear.link = node;
			rear = node;
		}
		size++;
	}
}
