package chapter01.exercise_1_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_1_39 {
	
	public static int binarySearch(int[] a, int key, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = (hi - lo) / 2 + lo;
//		System.out.printf("lo=%d, hi=%d, mid=%d\n",lo, hi, mid);
		if (key > a[mid]) return binarySearch(a, key, mid + 1, hi);
		else if (key < a[mid]) return binarySearch(a, key, lo, mid - 1);
		else return mid;
	}
	
	public static int runSearch(int N) {
		int [] a = new int[N];
		int [] b = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(100000, 1000000);
			b[i] = StdRandom.uniform(100000, 1000000);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			if (binarySearch(b, a[i], 0, a.length - 1) != -1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("T\t N\t AVG\t");
		for (int k = 1; k < 10; k++) {
			int T = (int) Math.pow(10, k);
			int [] ns = {1000, 10000, 100000, 1000000};
			
			System.out.println("==================");
			for (int i = 0; i < 4; i++) {
				int N = ns[i];
				double avg = 0;
				int result = 0;
				for (int j = 0; j < T; j++) {
					 result += runSearch(N);
				}
				avg = 1.0 * result / T;
				System.out.printf("%d\t%d\t%.2f\t\n", T, N, avg);
			}
		}
		
	}
}
