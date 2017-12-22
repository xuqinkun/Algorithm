package chapter01.exercise_1_1;

import java.util.Arrays;

public class Exercise_1_1_22 {
	
	
	public static int rank(int key, int a[], int lo, int hi, int level) {
		if (lo > hi) return -1;
		for (int i = 0; i < level; i++) {
			System.out.print(" ");
		}
		System.out.print("lo:" + lo + ", hi:" + hi + "\n");
		int mid = (lo + hi) / 2;
		if (key > a[mid]) 
			return rank(key, a, mid + 1, hi, ++level);
		else if (key < a[mid]) 
			return rank(key, a, lo, mid - 1, ++level);
		else return mid;
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,5,4,9,11,10};
		Arrays.sort(a);
		int key = 10;
		System.out.println(rank(key,a));
	}

	private static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1, 0);
	}
}
