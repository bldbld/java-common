package org.ballad.javacommon.basic.common.ds.heap;

/**
 * 最小堆示例<br>
 * 实现原理同java.util.PriorityQueue<br>
 * MinHeap对于字符串比较采用了ASIC码比较 所以11要比2小
 * 
 * @author ballad
 * @version 2010/06/04
 * @version 2012/04/26 Code Format
 */
public class MinHeap {

	public static void main(String[] args) {
		MinHeap mh = new MinHeap();

		mh.add("2");
		mh.add("1");
		mh.add("4");
		mh.add("11");
		mh.add("5");

		System.out.println(mh.size());

		System.out.println(mh.remove());
		System.out.println(mh.remove());
		System.out.println(mh.remove());
	}

	public MinHeap() {
		currentSize = 0;
		array = new String[DEFAULT_CAPACITY + 1];
	}

	public MinHeap(String[] a) {
		currentSize = a.length;
		array = new String[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			array[i + 1] = a[i];
		}
	}

	public int size() {
		return currentSize;
	}

	public boolean isEmpty() {
		if (array[1] == null)
			return true;
		else
			return false;
	}

	public String element() {
		if (isEmpty())
			return null;
		else
			return array[1];
	}

	public boolean add(String x) {
		if (currentSize + 1 == array.length)
			doubleArray();

		// Percolate up 向上过滤法
		// PS:这个策略很nice
		int hole = ++currentSize;
		array[0] = x;
		for (; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
			array[hole] = array[hole / 2];
		}
		array[hole] = x;
		return true;
	}

	public String remove() {
		if (isEmpty())
			return null;
		else
			return deleteMin();
	}

	public void buildHeap() {
		/*
		 * 线性时间的堆构造：
		 * 
		 * i选取currentSize/2的原因： 所有i的后代都被调用过percolateDown(i)处理的有序了
		 */
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	private void doubleArray() {
		// Double the length of array for more items
	}

	private String deleteMin() {
		String minItem = element();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	private void percolateDown(int hole) {
		// Percolate down 向下过滤法
		int child = hole * 2;
		String tmp = array[hole];
		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize
					&& array[child + 1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}

	private int currentSize;
	private String[] array; // The heap array

	final static public int DEFAULT_CAPACITY = 30;
}
