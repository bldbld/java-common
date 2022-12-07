package org.ballad.javacommon.datastructure.tree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTreeTest.binaryTreeTest();

	}

	public static void binaryTreeTest() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(new Integer(
				6));
		BinaryTree<Integer> bTree = new BinaryTree<Integer>(root);
		BinaryTreeNode<Integer> left1 = new BinaryTreeNode<Integer>(
				new Integer(4));
		BinaryTreeNode<Integer> right1 = new BinaryTreeNode<Integer>(
				new Integer(9));
		BinaryTreeNode<Integer> left11 = new BinaryTreeNode<Integer>(
				new Integer(2));
		BinaryTreeNode<Integer> left12 = new BinaryTreeNode<Integer>(
				new Integer(3));
		BinaryTreeNode<Integer> left111 = new BinaryTreeNode<Integer>(
				new Integer(1));
		BinaryTreeNode<Integer> right12 = new BinaryTreeNode<Integer>(
				new Integer(16));
		left11.setLeft(left111);
		left1.setLeft(left11);
		left1.setRight(left12);
		right1.setRight(right12);
		root.setLeft(left1);
		root.setRight(right1);
		bTree.printLevelOrder();
	}
}
