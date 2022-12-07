package org.ballad.javacommon.datastructure.tree;

/**
 * BST ƽ�������<br>
 * ��Ϊ�����һ�����������<br>
 * BST���ڴ��������ɾ��������ƽ��ʱ����0(log N),��������ʱO��N��<br>
 * ��BSTΪ�˷���Ƚ�ֻ��ʵ����String�汾<br>
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/30 code format
 */
public class BST {

	private BSTNode root;

	public BST() {

	}

	public BST(String element) {
		root = new BSTNode(element);
	}

	/**
	 * ��root�ڵ�������
	 * 
	 * @param element
	 * @return
	 */
	public BSTNode find(String element) {
		BSTNode t = root;
		while (t != null) {
			if (element.compareTo(t.element) < 0)
				t = t.left;
			else if (element.compareTo(t.element) > 0)
				t = t.right;
			else
				return t;
		}
		return null;
	}

	/**
	 * ��ָ���ڵ�������
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	public BSTNode find(String element, BSTNode node) {
		BSTNode t = node;
		while (t != null) {
			if (element.compareTo(t.element) < 0)
				t = t.left;
			else if (element.compareTo(t.element) > 0)
				t = t.right;
			else
				return t;
		}
		return null;
	}

	public BSTNode insert(String element) {
		BSTNode t = root;
		return insert(element, t);
	}

	public BSTNode insert(String element, BSTNode node) {
		/*
		 * ԭ��˵���� elementͬ��ǰ�ڵ��ֵ���бȽ� ���С�������������ִ�в���
		 */
		if (node == null)
			node = new BSTNode(element);
		else if (element.compareTo(node.element) < 0)
			node.left = insert(element, node.left);
		else if (element.compareTo(node.element) > 0)
			node.right = insert(element, node.right);
		else
			return null;
		return node;

	}

}
