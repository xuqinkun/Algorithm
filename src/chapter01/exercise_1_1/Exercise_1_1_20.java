package chapter01.exercise_1_1;

public class Exercise_1_1_20 {

	public static int factorial(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
