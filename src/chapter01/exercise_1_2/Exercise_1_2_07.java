package chapter01.exercise_1_2;

public class Exercise_1_2_07 {
	
	public static String mystery(String s) {
		int n = s.length();
		if (n <= 1) return s;
		String a = s.substring(0, n / 2);
		String b = s.substring(n / 2, n);
		return mystery(a) + mystery(b);
	}
	
	public static void main(String[] args) {
		System.out.println(mystery("123"));
	}
}
