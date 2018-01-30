package chapter02.example_2_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {
	
	public static void sort(int [] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) h = 3 * h + 1;
		while (h >= 1) {
			System.out.println("h=" + h);
			for (int j = h; j < N; j ++) {
				for (int k = j; k >= h; k -= h) {
					System.out.printf("j=%d, k=%d\n",j,k);
					if (a[k] < a[k - h]) exch(a, k , k - h);
				}
			}
			h /= 3;
		}
	}
	
	private static void exch(int[] a, int i, int j) {
		System.out.printf("Exchange:(%d,%d)\n",i,j);
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		System.out.println("After exchanging:" + Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		int []a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(1,100);
		}
		System.out.println("Before Sorting:" + Arrays.toString(a));
		ShellSort.sort(a);
		System.out.println("After Sorting:" + Arrays.toString(a));
	}
}
