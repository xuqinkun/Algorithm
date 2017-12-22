package chapter01.exercise_1_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_1_36 {
	
	public static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = i + StdRandom.uniform(N-i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	public static void init(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}
	
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int [] a = new int[M];
		int [][] b = new int[M][M];
		for (int i = 0; i < N; i++) {
			init(a);
			shuffle(a);
			for (int j = 0; j < a.length; j++) {
				b[a[j]][j]++;  
			}
		}
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.printf("%4d ", b[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
