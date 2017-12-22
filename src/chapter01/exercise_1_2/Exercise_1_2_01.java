package chapter01.exercise_1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1_2_01 {
	
	public static double dist(Point2D p1, Point2D p2) {
		double x = p1.x() - p2.x();
		double y = p1.y() - p2.y();
		return x * x + y * y;
	}
	
	public static double minDist(int N) {
		Point2D [] points = new Point2D[N];
		StdDraw.setScale(0,1);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.005);
		for(int i = 0; i < points.length; i++) {
			points[i] = new Point2D(StdRandom.uniform(0.0, 1.0),
					StdRandom.uniform(0.0, 1.0));
			points[i].draw();
		}
		double max = Double.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			
			for (int j = i + 1; j < points.length; j++) {
				double dist = dist(points[i], points[j]);
				if (dist < max) {
					max = dist;
				}
			}
		}
		return Math.sqrt(max);
	}
	
	public static void main(String[] args) {
		System.out.println(minDist(100));
	}
}
