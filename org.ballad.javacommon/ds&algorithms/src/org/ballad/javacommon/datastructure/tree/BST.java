package org.ballad.javacommon.datastructure.tree;

/**
 * BST 平衡二叉树<br>
 * 作为链表的一种替代方案，<br>
 * BST对于大多数插入删除操作的平均时间是0(log N),最坏的情况下时O（N）<br>
 * 本BST为了方便比较只是实现了String版本<br>
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
	 * 从root节点向下找
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
	 * 从指定节点向下找
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
		 * 原理说明： element同当前节点的值进行比较 如果小，则对其左子树执行插入
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
