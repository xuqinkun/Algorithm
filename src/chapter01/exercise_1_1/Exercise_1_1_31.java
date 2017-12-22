package chapter01.exercise_1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_1_1_31 {

	public static void draw(int N, double p) {
		StdDraw.setCanvasSize(512, 512);
//		StdDraw.setScale(-512, 512);
		int scale = N + 2;
		StdDraw.setXscale(-scale, scale);
		StdDraw.setYscale(-scale, scale);
		int centerX = 0;
		int centerY = 0;
		StdDraw.circle(centerX, centerY, N);
		StdDraw.setPenRadius(0.05);
		
		for (int i = centerX; i < N; i++) {
			double x = centerX + Math.sin(2*i*Math.PI/N)*N;
			double y = centerY + Math.cos(2*i*Math.PI/N)*N;
			StdOut.printf("(%f,%f)",x,y);
			StdDraw.point(x, y);
		}
	}
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		double min = Math.min(1, p);
		draw(N, min);
	}
}
