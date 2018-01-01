package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tokenizer {
	private static final Set<String> OPERATOR = new HashSet<String>(Arrays.asList("(",")","+","-","*","/"));
	private static final String NUMBER_REGEX = "\\d+(\\.\\d+)?";
	
	public static String[] getTokens(String src, String regex) {
		Matcher m = getMatcher(src, regex);
		List<String> list = new ArrayList<>();
		while (m.find()) {
			list.add(m.group());
		}
		int size = list.size();
		String[] tokens = new String[size];
		for (int i = 0; i < size; i++) {
			tokens[i] = list.get(i);
		}
		return tokens;
	}
	
	public static Stack<Double> parseNumber(String exp) {
		Matcher m = getMatcher(exp, NUMBER_REGEX);
		Stack<Double> nums = new Stack<>();
		while (m.find()) {
			String d = m.group();
			nums.push(Double.parseDouble(d));
		}
		return nums;
	}

	private static Matcher getMatcher(String exp, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(exp);
		return m;
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
			stack.push(s);
		}
		return stack;
	}
	
	public static boolean isDigit(String exp) {
		Matcher m = getMatcher(exp, NUMBER_REGEX);
		return m.matches();
	}
}
