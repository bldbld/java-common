package org.ballad.javacommon.basic.common.ds.heap;

/**
 * 二叉堆 Binary Heap
 * 
 * Description:
 * 
 * 非平衡的BST没有较好的最坏情况性能，而平衡BST又需要做许多工作 可以以对数时间完成Insert和DeleteMin操作 Binary
 * Heap具有结构性和有序性
 * 
 * 结构性：Binary Heap基于Complete Binary Tree(完全二叉树), 是完全填满的树，底层例外。
 * 对于位置为i节点（前序遍历）来说，父节点在位置∟i/2」,左孩子在位置2i，有孩子2i+1
 * 
 * 有序性：父节点的值小于子节点的值
 * 
 * --最大堆 Max Heap：支持最大元素的访问而不是最小的
 * 
 * 定理： --对于一个高度为H，包含（N=2的（H+1）次幂 -1）个节点的满二叉树， --节点的高度为N-H-1
 * 
 * @author ballad
 * @version 2010/04/27 initial
 */
public class BinaryHeap {

}
