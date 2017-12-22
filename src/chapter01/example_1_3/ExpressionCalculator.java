package chapter01.example_1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionCalculator {
	
	private Stack<Character> opStack = new Stack<>();
	private Stack<Integer> numStack = new Stack<>();
	private char [] ops = new char[]{'(',')','+','-','*','/'}; 
	
	public void read() throws IOException {
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		System.out.println("Input expression:");
		while ((line = br.readLine()) != null) {
			
			if (line.equalsIgnoreCase("exit")) {
				break;
			}
			if (!isValid(line)) {
				System.out.println("Expression is not valid!");
				continue;
			}
			
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (isOperator(c)) {
					opStack.push(c);
				}
				if (Character.isDigit(c)) {
					numStack.push(c - '0');
				}
			}
			int result = calculate(opStack, numStack);
			System.out.println(line + " = " + result);
			System.out.println("Input expression:");
		}
	}


	public int calculate(Stack<Character> ops, Stack<Integer> nums) {
		if (ops.isEmpty()) {
			return nums.pop();
		}
		Character op = ops.pop();
		Integer num = nums.pop();
		if (nums.isEmpty()) {
			return num;
		}
		if (op == '+') return num + calculate(ops, nums);
		else if (op == '-') return num - calculate(ops, nums);
		else if (op == '*') {
			Integer num2 = nums.pop();
			nums.push(num * num2);
			return calculate(ops, nums);
		}
		else if (op == '/') {
			Integer num2 = nums.pop();
			nums.push(num2 / num);
			return calculate(ops, nums);
		}
		else 
			return 0;
	}


	private boolean isValid(String line) {
		return true;
	}

	private boolean isOperator(char c) {
		if (binarySearch(ops, c) >= 0) {
			return true;
		}
		return false;
	}
	
	private  int binarySearch(char[] src, char target) {
		return binarySearch(src, target, 0, src.length - 1);
	}
	
	private  int binarySearch(char[] src, char target, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = (lo + hi) / 2;
		if (src[mid] < target) return binarySearch(src, target, mid + 1, hi);
		if (src[mid] > target) return binarySearch(src, target, lo, mid - 1);
		return mid;
	}
	
	public static void main(String[] args) throws IOException {
		ExpressionCalculator calculator = new ExpressionCalculator();
		calculator.read();
	}
}
