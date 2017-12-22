package chapter01.exercise_1_1;

public class Exercise_1_1_16 {
	
	public static String exR1(int n) {
		if (n <= 0) return "";
		return exR1(n-3) + n + exR1(n-2) + n;
	}
	
	public static void main(String[] args) {
		String r = exR1(6);
		System.out.println(r);
	}
}
