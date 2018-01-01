package example_2_1;

import java.util.Arrays;

public class InsertSort {
	
	public static void sort(int [] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j-1]) exch(a, j-1, j);
			}
		}
	}

	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		int [] a = new int[] {1,4,100,2,3,5,10,-1};
		InsertSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
