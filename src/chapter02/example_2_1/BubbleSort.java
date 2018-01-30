package chapter02.example_2_1;

import java.util.Arrays;

public class BubbleSort {
	
	public void sort(int [] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int flag = 0;
			for (int j = a.length-1; j > i; j--) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j - 1);
					flag++;
				}
				System.out.println(Arrays.toString(a));
			}
			if(flag == 0) {
				break;
			}
		}
	}

	private void exch(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] =tmp;
	}

	private boolean less(int i, int j) {
		return i < j;
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int[] a = new int[] {1,7,9,8,2,3,5};
		bs.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
