package example_2_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	
	public static void sort (int [] a, int lo, int hi) {
		if (lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a,j + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int v = a[hi];
		int left = lo - 1;
		int right = hi;
		while (true) {
			while (a[++left] < v) {
				if (left == hi) break;
			}
			while (a[--right] > v) {
				if (right == lo) break;
			}
			if (left >= right) {
				break;
			}
			exch(a, left, right);
		}
		exch(a, hi, left);
		return left;
	}

	private static void exch(int[] a, int i, int j) {
		System.out.printf("Exchange:(%d,%d)\n",i,j);
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		System.out.println("After exchanging:" + Arrays.toString(a));
	}
	
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		int []a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(1,100);
		}
		System.out.println("Before Sorting:" + Arrays.toString(a));
		QuickSort.sort(a);
		System.out.println("After Sorting:" + Arrays.toString(a));
	}

}
