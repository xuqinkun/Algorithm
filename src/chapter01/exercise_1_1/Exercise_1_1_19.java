package chapter01.exercise_1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Fibonacci
 * @author xuqin
 *
 */
public class Exercise_1_1_19 {
	static long [] nums = null; 
	public static long F(int n) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (nums[n] != 0) return nums[n];
		return F(n-1) + F(n-2);
	}
	
	public static void main(String[] args) {
		int N = 100;
		if (nums == null) {
			nums = new long[N];
		}
		for (int i = 0; i < N; i++) {
			long result = F(i);
			nums[i] = result;
			StdOut.println(i + " " + result);
		}
	}
}
