package other;
/**
 *   1  2  8  9
 *   2  4  9 12
 *   4  7 10 13
 *   6  8 11 15
 *   
 * @author xuqin
 *
 */
public class FindInPartiallySortedArray {
	
	public static boolean find(int[][] a, int key) {
		int i = 0, j = 0;
		int row = a.length, col = a[0].length;
		if (a[0][0] > key || a[row - 1][col-1] < key) {
			return false;
		}
		while (i < row && j < col) {
			if (a[i][j] == key || a[i][j+1] == key || a[i+1][j]==key) {
				return true;
			}
			else if (a[i][j] < key && a[i][j+1] > key) {
				i++;
			}
			else if (a[i][j] < key && a[i+1][j] > key) {
				j++;
			}
			else {
				i++;
				j++;
			}
		}
		return false;
	}
	
	public static boolean binarySearch(int[][] a, int key) {
		return binarySearch(0,a,  0, 0, a[0].length - 1, a.length - 1, key);
	}
	
	private static boolean binarySearch(int count, int[][] a, int loX, int loY, int hiX, int hiY, int key) {
		if (loX > hiX || loY > hiY) {
			return false;
		}
		int midX = (loX + hiX) / 2;
		int midY = (loY + hiY) / 2;
		if (a[midX][midY] == key) {
			return true;
		} else if (midX - 1 >= 0 && a[midX-1][midY] == key) {
			return true;
		} else if (midY - 1 >= 0 && a[midX][midY-1] == key) {
			return true;
		} else if (a[midX][midY] > key) {
			return binarySearch(++count, a, loX, loY, midX - 1, midY - 1, key);
		} else if (a[midX][midY] < key) {
			return binarySearch(++count,a, midX + 1, midY + 1, hiX, hiY, key);
		} 
		return false;
	}
	
	
	public static boolean solution(int[][] a, int key) {
		int i = 0, j = a[0].length - 1;
		while (i < a.length && j >= 0) {
			if (a[i][j] == key) {
				return true;
			}
			else if (a[i][j] < key) {
				i++;
			}
			else if (a[i][j] > key) {
				j--;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] a = new int[][]{ {1, 2, 8, 9},
								 {2, 4, 9, 12},
								 {4, 7, 10, 13}
								};
		int key = 4;
		System.out.println(solution(a, key));
								
	}
}
