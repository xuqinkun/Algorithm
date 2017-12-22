package chapter01.example_1_1;

public class BinarySearch {
	
	public static int rank(int[] a, int target, int lo, int hi, Counter counter) {
		counter.increment();
		if (lo > hi) return -1;
		int mid = (lo + hi) / 2;
		if (a[mid] > target) return rank(a, target, lo, mid - 1, counter);
		if (a[mid] < target) return rank(a, target, mid + 1, hi, counter);
		return mid;
	}
	
	public static int rank(int[] a, int target, Counter counter) {
		return rank(a, target, 0, a.length, counter);
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5};
		int target = 5;
		Counter counter = new Counter("BinarySearch");
		System.out.println(rank(a, target, counter));
		System.out.println(counter);
	}
	
}
