package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegualrExpression {
	private static final Set<String> OPERATOR = new HashSet<String>(Arrays.asList("+","-","*","/"));
	
//	public static double [] parseNum(String exp) {
//		String regex = getRegex();
//		String[] strNum = exp.split(regex);
//		double [] nums = new double[strNum.length];
//		for (int i = 0; i < strNum.length; i++) {
//			nums[i] = Double.parseDouble(strNum[i]);
//		}
//		return nums;
//	}

	public static Stack<Double> parseNumber(String exp) {
		Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
		Matcher m = p.matcher(exp);
		Stack<Double> nums = new Stack<>();
		while (m.find()) {
			String d = m.group();
			nums.push(Double.parseDouble(d));
		}
		return nums;
	}
	
	private static String getRegex() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (String op : OPERATOR) {
			sb.append("\\" + op + "||");
		}
		int len = sb.length();
		sb.delete(len-2, len);
		sb.append("]");
		String regex = sb.toString();
		return regex;
	}
	
	public static Stack<String> parseOperator(String exp) {
		Stack<String> stack = new Stack<>();
		Pattern pattern = Pattern.compile(getRegex());
		Matcher m = pattern.matcher(exp);
		String s = null;
		while(m.find()) {
			s = m.group();
			System.out.println(s);
			stack.push(s);
		}
		return stack;
	}
	
	public static void main(String[] args) {
		String exp = "1111+2.3-3*4+2.1";
//		System.out.println(Arrays.toString(parseNum(exp)));
//		Stack<String> stack = parseOperator(exp);
		parseNumber(exp);
	}
}
