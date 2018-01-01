package other;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class MergeArray {
	
	public int[] merge(int[] a, int[] b) {
		int len = a.length + b.length;
		int c[] = new int[len];
		int i = 0, j = 0, index = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[index++] = a[i++];
				
			} else if (a[i] > b[j]){
				c[index++] = b[j++];
			} else {
				c[index++] = a[i++];
				c[index++] = b[j++];
			}
		}
		while (i < a.length) {
			c[index++] = a[i++];
		}
		while (j < b.length) {
			c[index++] = b[j++];
		}
		return c;
	}
	
	public int[] generateRandomArray(int n, int max) {
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = StdRandom.uniform(max);
		}
		return a;
	}
	
	public static void main(String[] args) {
		MergeArray ma = new MergeArray();
		int[] a = ma.generateRandomArray(10, 100);
		int[] b = ma.generateRandomArray(10, 100);
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println("a=" + Arrays.toString(a));
		System.out.println("b=" + Arrays.toString(b));
		int[] c = ma.merge(a, b);
		System.out.println("c=" + Arrays.toString(c));
	}
}
