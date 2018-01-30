package chapter02.example_2_1;

import java.util.Arrays;
import java.util.List;

public class MaxHeap<Key extends Comparable<Key>> {
	private Key[] elements;	// 基于堆的完全二叉树
	private int N = 0;		// 存储于elements[1..N]中，elements[0]作为哨兵，可以避免交换操作
	
	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		elements = (Key[])new Comparable[size + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		elements[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		Key max = elements[1];	// 从根节点得到最大元素
		exch(1, N--);			// 将其和最后一个节点交换
		elements[N+1] = null;	// 防止对象游离
		sink(1);				// 恢复堆的有序性
		return max;
	}
	
	private boolean less(int i, int j) {
		return elements[i].compareTo(elements[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = elements[j];
		elements[j] = elements[i];
		elements[i] = t; 
	}
	
	private void swim(int k) {
		while (k > 1 && less(k / 2,k)) {
			exch(k, k / 2);
			k /= 2;
		}
	}
	
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("TPROASEIHG".split(""));
		MaxHeap<String> heap = new MaxHeap<String>(list.size());
		for (String s : list) {
			heap.insert(s);
		}
		while (!heap.isEmpty()) {
			String item = heap.delMax();
			System.out.print(item + " ");
		}
	}

}
