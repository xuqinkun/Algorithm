package chapter01.example_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import other.Tokenizer;

public class ExpressionCalculator {
	
//	private char [] ops = new char[]{'(',')','+','-','*','/'}; 
	private static final Set<String> OPERATOR = new HashSet<String>(
			Arrays.asList("+","-","*","/", "sin", "cos", "tan"));
	
	public void calculate(int accuracy) throws IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("Input expression:");
		while ((line = br.readLine()) != null) {
			if (isValid(line)) {
				double result = calculate(line);
				BigDecimal bd = new BigDecimal(result);
				double fixedResult = bd.setScale(accuracy, BigDecimal.ROUND_HALF_UP).
									doubleValue();
				System.out.println(line + " = " + fixedResult);
			} else {
				System.out.println("Expression is not valid!");
			}
			System.out.println("Input expression:");
		}
		br.close();
	}

	public double calculate(String line) {
		String regex = getRegex();
		String[] tokens = Tokenizer.getTokens(line, regex);
		Stack<String> ops = new Stack<>();
		Stack<Double> nums = new Stack<>();
		
		int len = tokens.length;
		for (int i = 0; i < len; i++) {
			String token = tokens[i];
			if (token.equals("(") && i != 0) {
				String op = ops.pop();
				doCalculate(ops, nums);
				ops.push(op);
			}
			else if (OPERATOR.contains(token)) {
				ops.push(token);
			}
			else if (token.equals(")")) {
				doCalculate(ops, nums);
			}
			else if (Tokenizer.isDigit(token)) {
				nums.push(Double.parseDouble(token));
			}
		}
		doCalculate(ops, nums);
		Double result = nums.pop();
		
		return result;
	}

	private String getRegex() {
		String regex = "";
		for (String op : OPERATOR) {
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			if (op.length() == 1) {
				sb.append("\\" + op);
			} else {
				sb.append(op);
			}
			sb.append(")");
			regex += sb.toString() +"|";
		}
		regex += "(\\()|(\\))|(\\d+(\\.\\d+)?)";
		return regex;
	}


	private void doCalculate(Stack<String> ops, Stack<Double> nums) {
		if (ops.isEmpty()) return;
		String op = ops.pop();
		Double num1 = nums.pop();
		if (op.equals("*")) {
			nums.push(nums.pop() * num1);
		}
		else if (op.equals("/")) {
			nums.push(nums.pop() / num1);
		}
		else if (op.equals("+")) {
			nums.push(nums.pop() + num1);
		}
		else if (op.equals("-")) {
			nums.push(nums.pop() - num1);
		}
		else if (op.equals("sin")) {
			nums.push(Math.sin(num1/180*Math.PI));
		}
		else if (op.equals("cos")) {
			nums.push(Math.cos(num1/180*Math.PI));
		}
		
		doCalculate(ops, nums);
	}

	private boolean isValid(String line) {
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		ExpressionCalculator calculator = new ExpressionCalculator();
		calculator.calculate(2);
		
	}
}
