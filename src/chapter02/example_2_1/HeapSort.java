package chapter02.example_2_1;

import java.util.Arrays;

public class HeapSort {

	public  static <T extends Comparable<T>> void sort(T[] a) {
		int N = a.length - 1;
		for (int k = N / 2 - 1; k >= 0; k--) {
			sink(a, k, N);
		}
		while (N > 0) {
			exch(a, 0, N--);
			sink(a, 0, N);
		}
	}

	private static <T extends Comparable<T>> void sink(T[] a, int k, int n) {
		while (k * 2 <  n) {
			int j = k * 2 + 1;
			if (j < n && less(a, j, j + 1)) j++;
			if (!less(a, k, j)) break;
			exch(a, k, j);
			k = j;
		}
	}

	private static <T> void exch(T[] a, int i, int j) {
		T key = a[i];
		a[i] = a[j];   
		a[j] = key;
	}

	private static <T extends Comparable<T>> boolean less(T[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	
	public static void main(String[] args) {
		String [] a = "XTPROAIHGJQ".split("");
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
