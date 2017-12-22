package chapter01.exercise_1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_1_35 {
	private static final int SIDES = 6;
	
	public static double[] prop() {
		double [] dist = new double[SIDES * 2 + 1];
		
		for (int i = 1; i <= SIDES; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dist[i+j] += 1;
			}
		}
		for(int i = 1; i < dist.length; i++)
			dist[i] /= 36.0;
		return dist;
	}
	
	public static double[] throwDice(int N) {
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 0; i < N; i++) {
			int r1 = StdRandom.uniform(1,6);
			int r2 = StdRandom.uniform(1,6);
			dist[r1+r2]++;
		}
		for (int i = 1; i < dist.length; i++) {
			dist[i] /= N;
		}
		return dist;
	}
	
	public static void print(double [] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%d-->%f\n",i, data[i]);
		}
	}
	
	public static void print(double [] a, double [] b) {
		for (int i = 1; i < a.length; i++) {
			System.out.printf("%d-->|%f - %f| = %f\n",i, a[i], b[i], Math.abs(a[i] - b[i]));
		}
	}
	
	public static void main(String[] args) {
		double[] standData = prop();
		double[] testData = throwDice(1000000000);
		print(standData, testData);
		double result = 0;
		for (double d : testData) {
			result += d;
		}
		System.out.println("result: " + result);
		
	}
}
