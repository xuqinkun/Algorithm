package chapter01.example_1_3;

import other.Tokenizer;

public class ResizingCapacityStack<E> {
	private E[] elements;
	private int size;
	private static final int INITIAL_SIZE = 2;
	
	@SuppressWarnings("unchecked")
	public ResizingCapacityStack() {
		elements = (E[])new Object[INITIAL_SIZE];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(E e) {
		int len = elements.length;
		if (size == len) resize(2 * len);
		elements[size++] = e;
	}
	
	public E pop() {
		E e = elements[--size];
		elements[size] = null;
		if (size > 0 && size == elements.length / 4) {
			resize(elements.length / 2);
		}
		return e;
	}
	
	public int size() {
		return elements.length;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int len) {
		E[] temp = (E[]) new Object[len];
		System.arraycopy(elements, 0, temp, 0, size);
		elements = temp;
	}
	
	public static void main(String[] args) {
		ResizingCapacityStack<Integer> stack = new ResizingCapacityStack<>();
		for (int i = 0; i < 100; i++) {
			stack.push(i);
			System.out.printf("size=%d, capacity=%d\n", stack.size, stack.size());
		}
		for (int i = 0; i < 100; i++) {
			stack.pop();
			System.out.printf("size=%d, capacity=%d\n", stack.size, stack.size());
			
		}
	}
}
