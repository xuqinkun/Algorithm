package chapter02.example_2_1;

import java.util.Arrays;
import java.util.List;

public class MinHeap<Key extends Comparable<Key>> {
	private Key items[];
	private int N = 0;
	
	public MinHeap(int size) {
		items = (Key[]) new Comparable[size + 1];
	}
	
	public void insert(Key val) {
		checkCapacity();
		items[++N] = val;
		swim(N);
	}
	
	public Key peek() {
		return items[1];
	}
	
	private void checkCapacity() {
		int len = items.length;
		if (N + 1 >= len) {
			Key[] newItems = (Key[]) new Comparable[len * 2];
			System.arraycopy(items, 0, newItems, 0, len);
			items = newItems;
		}
	}

	private void swim(int k) {
		while (k > 1 && greater(k/2, k)) {
			exch(k/2, k);
			k >>= 1;
		}
	}

	private void exch(int i, int j) {
		Key item = items[i];
		items[i] = items[j];
		items[j] = item;
	}

	private boolean greater(int i, int j) {
		return items[i].compareTo(items[j]) > 0;
	}

	public Key delMin() {
		Key val = items[1];
		exch(1, N--);
		items[N+1] = null;
		sink(1);
		return val;
	}

	private void sink(int k) {
		while (k * 2 <= N) {
			int j = k * 2;
			if (j < N && greater(j, j + 1)) j++;
			if (!greater(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("TPROASEIHG".split(""));
		MinHeap<String> heap = new MinHeap<String>(list.size());
		for (String s : list) {
			heap.insert(s);
		}
		while (!heap.isEmpty()) {
			String item = heap.delMin();
			System.out.print(item + " ");
		}
	}

}
