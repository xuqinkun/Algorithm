package chapter01.example_1_1;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
	private int max;
	private int count;
	private int x;
	
	public VisualCounter(int max, int N) {
		StdDraw.setCanvasSize(1024, 1024);
		StdDraw.setXscale(0, N + 1);
		StdDraw.setYscale(-max, max);
		StdDraw.setPenColor(StdDraw.RED);
	}

	public void increment() {
		StdDraw.point(++x, ++count);
	}
	
	public void decrement() {
		StdDraw.point(++x, --count);
	}
	
	public static void main(String[] args) {
		VisualCounter vc = new VisualCounter(100, 200);
		for (int i = 0; i < 50; i++) {
			vc.increment();
			vc.increment();
			vc.decrement();
		}
		
	}
}
