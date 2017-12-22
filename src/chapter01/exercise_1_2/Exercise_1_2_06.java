package chapter01.exercise_1_2;

public class Exercise_1_2_06 {

	public static boolean isCircularRotation(String s1, String s2) {
		return s1.length() == s2.length() && 
				(s1.concat(s1).indexOf(s2) > -1);
	}
	
	public static void main(String[] args) {
		System.out.println(isCircularRotation("ACTGACG", "TGACGAC"));
	}
}
