package org.ballad.javacommon.basic.common.ds.collection;

/**
 * ������<br>
 * 
 * first����Ԫ�� first��λ��Ϊ0
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
		 * ��posλ��֮�����element
		 */
		if (length <= 1) {
			last.elenemt = element;
			length = 2;
		} else if (pos >= length - 1) {
			// ���posָ���˶�β���Ժ��λ�� ֱ���ڶ�β����
			Node<T> tmp = new Node<T>(element);
			last.link = tmp;
			last = tmp;
			length++;
		} else {
			Node<T> t = first;
			for (int i = 0; i < pos; i++) {
				// �ҵ�Ҫ����Ľڵ�ǰ���λ��
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
		 * ��posλ��֮��ɾ�� pos>=1
		 */
		if (length <= 1 || pos == 0 || pos > length - 1) {
			return;
		} else {
			Node<T> t = first;
			for (int i = 0; i < pos - 1; i++) {
				// �ҵ�Ҫɾ���ڵ��ǰһ���ڵ�
				t = t.link;
			}
			if (t.link.link == null) {
				// pos���Ƕ�β
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
