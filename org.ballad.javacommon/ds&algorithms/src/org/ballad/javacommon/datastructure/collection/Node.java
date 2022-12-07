package org.ballad.javacommon.datastructure.collection;

public class Node<T> {
	public T elenemt;
	public Node<T> link;

	public Node() {
		this.elenemt = null;
		this.link = null;
	}

	public Node(T element) {
		this.elenemt = element;
		this.link = null;
	}

	public String getElement() {
		return this.elenemt.toString();
	}
}
