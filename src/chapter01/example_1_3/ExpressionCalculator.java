package chapter01.example_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Stack;

import util.Tokenizer;

public class ExpressionCalculator {
	
//	private char [] ops = new char[]{'(',')','+','-','*','/'}; 
//	private static final Set<String> OPERATOR = new HashSet<String>(Arrays.asList("(",")","+","-","*","/"));
	
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
		String regex = "([\\+\\-\\*\\/\\(\\)])|(\\d+(\\.\\d+)?)";
		String[] tokens = Tokenizer.getTokens(line, regex);
		Stack<String> ops = new Stack<>();
		Stack<Double> nums = new Stack<>();
		
		int len = tokens.length;
		for (int i = 0; i < len; i++) {
			String token = tokens[i];
			if (token.equals("(")) {
				String op = ops.pop();
				calculate(ops, nums);
				ops.push(op);
			}
			else if (token.equals("+") || token.equals("-")
						|| token.equals("*") || token.equals("/")) {
				ops.push(token);
			}
			else if (token.equals(")")) {
				calculate(ops, nums);
			}
			else {
				nums.push(Double.parseDouble(token));
			}
		}
		calculate(ops, nums);
		Double result = nums.pop();
		
		return result;
	}


	private void calculate(Stack<String> ops, Stack<Double> nums) {
		if (ops.isEmpty()) return;
		String op = ops.pop();
		Double num1 = nums.pop();
		Double num2 = nums.pop();
		if (op.equals("*")) {
			nums.push(num2 * num1);
		}
		else if (op.equals("/")) {
			nums.push(num2 / num1);
		}
		else if (op.equals("+")) {
			nums.push(num2 + num1);
		}
		else if (op.equals("-")) {
			nums.push(num2 - num1);
		}
		calculate(ops, nums);
	}

	private boolean isValid(String line) {
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		ExpressionCalculator calculator = new ExpressionCalculator();
		calculator.calculate(2);
		
	}
}
