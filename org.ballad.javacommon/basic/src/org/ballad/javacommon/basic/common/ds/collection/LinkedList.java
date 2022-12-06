package org.ballad.javacommon.basic.common.ds.collection;

/**
 * 单链表<br>
 * 
 * first不存元素 first的位置为0
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/29 code format
 * 
 * @param <T>
 */
public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	public int length;

	public LinkedList() {
		first = new Node<T>();
		first.link = last;
		last = new Node<T>();
		last.link = null;
		length = 1;
	}

	public LinkedList(T element) {
		last = new Node<T>(element);
		last.link = null;
		first = new Node<T>();
		first.link = last;
		length = 2;
	}

	public void insert(T element, int pos) {
		/*
		 * 在pos位置之后插入element
		 */
		if (length <= 1) {
			last.elenemt = element;
			length = 2;
		} else if (pos >= length - 1) {
			// 如果pos指向了队尾及以后的位置 直接在队尾插入
			Node<T> tmp = new Node<T>(element);
			last.link = tmp;
			last = tmp;
			length++;
		} else {
			Node<T> t = first;
			for (int i = 0; i < pos; i++) {
				// 找到要插入的节点前面的位置
				t = t.link;
			}
			Node<T> tmp = new Node<T>(element);
			tmp.link = t.link;
			t.link = tmp;
			length++;
		}
	}

	public void remove(int pos) {
		/*
		 * 在pos位置之后删除 pos>=1
		 */
		if (length <= 1 || pos == 0 || pos > length - 1) {
			return;
		} else {
			Node<T> t = first;
			for (int i = 0; i < pos - 1; i++) {
				// 找到要删除节点的前一个节点
				t = t.link;
			}
			if (t.link.link == null) {
				// pos的是队尾
				t.link = null;
				last = t;
			} else
				t.link = t.link.link;
			length--;
		}
	}

	public void showList() {
		Node<T> t = first.link;
		while (t != null) {
			System.out.print(t.elenemt.toString() + " ");
			t = t.link;
		}
	}
}
