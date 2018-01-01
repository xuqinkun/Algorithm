package chapter01.example_1_3;

import java.util.NoSuchElementException;

public class LinkedList<E> {
	private Node header;
	private Node curr;
	private int size;
	
	public LinkedList() {
		header = new Node();
		curr = header;
	}
	
	public void insert(E val) {
		curr.next = new Node(val);
		curr = curr.next;
		size++;
	}
	
	public void insert(int index, E val) {
		if (index > size) {
			throw new NoSuchElementException();
		}
		int j = 0;
		Node item = header;
		while (j < index) {
			item = item.next;
			j++;
		}
		Node newItem = new Node(val);
		newItem.next = item.next;
		item.next = newItem;
	}
	
	public E get(int i) {
		Node item = header;
		int j = -1;
		while (j < i) {
			if (item == null) {
				throw new NoSuchElementException();
			} 
			item = item.next;
			j++;
		}
		return item.val;
	}
	
	public E remove() {
		Node item = header;
		while (item != null && item.next != curr) {
			item = item.next;
		}
		curr = item;
		Node temp = item.next;
		item.next = null;
		size--;
		return temp.val;
	}
	
	public void print() {
		Node item = header;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		while (item.next != null) {
			item = item.next;
			sb.append(item.val);
			sb.append(",");
		}
		int len = sb.length();
		if (len > 1) {
			sb.delete(len - 1, len);
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	private class Node {
		private E val;
		private Node next;
		public Node() {}
		public Node(E val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 100; i++) {
			list.insert(i);
		}
		list.print();
		for (int i = 0; i < 100; i++) {
			list.remove();
		}
		list.print();
		for (int i = 0; i < 10; i++) {
			list.insert(0, i);
			list.print();
		}
		new java.util.LinkedList<String>();
	}
}
