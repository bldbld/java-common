package org.ballad.javacommon.datastructure.tree;

import org.ballad.javacommon.datastructure.collection.Queue;

/**
 * ������<br>
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/30 code format
 * 
 * @param <T>
 */
public class BinaryTree<T> {
	private BinaryTreeNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootElement) {
		root = new BinaryTreeNode<T>(rootElement);
	}

	public BinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * ��ȡ���ڵ�
	 * 
	 * @return
	 */
	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * �жϷǿ�
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (root == null) ? false : true;
	}

	/**
	 * �ϲ�����������
	 */
	public void mergeTree(BinaryTreeNode<T> nodeFather, BinaryTree<T> left,
			BinaryTree<T> right) {
		if (left != null)
			nodeFather.left = left.root;
		if (right != null)
			nodeFather.right = right.root;
	}

	private void printNode(BinaryTreeNode<T> nodeName) {
		System.out.print(nodeName.getElement().toString() + " ");
	}

	/**
	 * ǰ����� ˳�� �� �� ��
	 */
	public void printPreOrder() {
		if (root != null) {
			System.out.println("ǰ�����:");
			preOrder(root);
		}
	}

	private void preOrder(BinaryTreeNode<T> root) {
		printNode(root);
		if (root.left != null)
			preOrder(root.left);
		if (root.right != null)
			preOrder(root.right);
	}

	/**
	 * ������� ˳�� �� �� ��
	 */
	public void printInOrder() {
		if (root != null) {
			System.out.println("�������:");
			inOrder(root);
		}
	}

	private void inOrder(BinaryTreeNode<T> root) {
		if (root.left != null)
			inOrder(root.left);
		printNode(root);
		if (root.right != null)
			inOrder(root.right);
	}

	/**
	 * ������� ˳�� �� �� ��
	 */
	public void printPostOrder() {
		if (root != null) {
			System.out.println("�������:");
			inOrder(root);
		}
	}

	private void postOrder(BinaryTreeNode<T> root) {
		if (root.left != null)
			postOrder(root.left);
		if (root.right != null)
			postOrder(root.right);
		printNode(root);
	}

	/**
	 * ��α��� ��ȱ���
	 * 
	 * @param element
	 */
	public void printLevelOrder() {
		if (root != null) {
			System.out.println("��ȱ���");
			levelOrder();
		}
	}

	private void levelOrder() {
		Queue<BinaryTreeNode<T>> queue = new Queue<BinaryTreeNode<T>>();
		queue.offer(root);
		for (int i = 0; i < root.getSize(); i++) {
			if (queue.getFront().left != null) {
				queue.offer(queue.getFront().left);
			}
			if (queue.getFront().right != null) {
				queue.offer(queue.getFront().right);
			}
			printNode(queue.pollFront());
		}
	}

	/**
	 * ��ӡԪ��
	 */
	public void printT(T element) {
		System.out.print(element.toString());
	}
}
