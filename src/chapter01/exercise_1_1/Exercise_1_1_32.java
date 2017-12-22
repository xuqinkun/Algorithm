package chapter01.exercise_1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

public class Exercise_1_1_32 {

	public static void drawRectangle(List<Integer> numList, int n, double l, double r) {
		int [] b = new int[n];
		double avgLen = (r - l) / n;
		for (int i = 0; i < n; i++) {
			Integer num = numList.get(i);
			if (num < r && num >= l) {
				int index = (int)(Math.floor((num - l) / avgLen));
				System.out.println("num:"+num +", index:"+index);
 				b[index]= b[index] + 1;
			}
		}
		
		StdDraw.setScale(-1, r+1);
		
		for (int i = 0; i < b.length; i++) {
			double x = l + i* avgLen + avgLen / 2.0 ;
			double y = b[i] / 2.0;
			StdDraw.filledRectangle(x, y, avgLen / 2, y);
		}
	}
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		System.out.println("l:"+ l +" , r:" +r);
		System.out.println("Input nums:");
		Scanner sc = new Scanner(System.in);
		List<Integer> numList = new ArrayList<>();
		if (sc.hasNextLine()) {
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line);
			while (sc2.hasNextInt()) {
				numList.add(sc2.nextInt());
			}
			sc2.close();
		}
		sc.close();
		drawRectangle(numList, N, l, r);
		
	}
}
