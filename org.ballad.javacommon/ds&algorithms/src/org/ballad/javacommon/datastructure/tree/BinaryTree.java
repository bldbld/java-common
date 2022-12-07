package org.ballad.javacommon.datastructure.tree;

import org.ballad.javacommon.datastructure.collection.Queue;

/**
 * 二叉树<br>
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
	 * 获取根节点
	 * 
	 * @return
	 */
	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * 判断非空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (root == null) ? false : true;
	}

	/**
	 * 合并两个二叉树
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
	 * 前序遍历 顺序 根 左 右
	 */
	public void printPreOrder() {
		if (root != null) {
			System.out.println("前序遍历:");
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
	 * 中序遍历 顺序 左 根 右
	 */
	public void printInOrder() {
		if (root != null) {
			System.out.println("中序遍历:");
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
	 * 后序遍历 顺序 左 右 根
	 */
	public void printPostOrder() {
		if (root != null) {
			System.out.println("后序遍历:");
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
	 * 层次遍历 广度遍历
	 * 
	 * @param element
	 */
	public void printLevelOrder() {
		if (root != null) {
			System.out.println("广度遍历");
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
	 * 打印元素
	 */
	public void printT(T element) {
		System.out.print(element.toString());
	}
}
