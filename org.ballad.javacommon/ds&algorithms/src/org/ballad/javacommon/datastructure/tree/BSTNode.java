package org.ballad.javacommon.datastructure.tree;

/**
 * BST Node
 * 
 * @author ballad
 * @version 2010/04/27 initial
 * @version 2012/04/30 code format
 */
public class BSTNode {
	public String element;
	public BSTNode left;
	public BSTNode right;

	public BSTNode() {

	}

	public BSTNode(String element) {
		this.element = element;
	}
}
