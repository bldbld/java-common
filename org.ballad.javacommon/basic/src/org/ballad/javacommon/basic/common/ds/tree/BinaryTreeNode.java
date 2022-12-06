package org.ballad.javacommon.basic.common.ds.tree;

/**
 * ¶þ²æÊ÷½Úµã
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/30 code format
 * 
 * @param <T>
 */
public class BinaryTreeNode<T> {
	public T element;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public BinaryTreeNode() {

	}

	public BinaryTreeNode(T element) {
		this.element = element;
	}

	public void setLeft(BinaryTreeNode<T> nodeName) {
		this.left = nodeName;
	}

	public void setRight(BinaryTreeNode<T> nodeName) {
		this.right = nodeName;
	}

	public String getElement() {
		return this.element.toString();
	}

	public int getSize() {
		int leftSize = 0, rightSize = 0;
		if (this.left != null) {
			leftSize = this.left.getSize();
		}
		if (this.right != null) {
			rightSize = this.right.getSize();
		}
		return 1 + leftSize + rightSize;
	}
}