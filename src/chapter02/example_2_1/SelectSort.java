package chapter02.example_2_1;

import java.util.Arrays;

public class SelectSort {
	
	public static void sort(int[] a) {
		
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) min = j;
			}
			exch(a, i, min);
		}
	}

	private static void exch(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	public static void main(String[] args) {
		int [] a = new int[] {1,4,100,2,3,5,10,-1};
		SelectSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
