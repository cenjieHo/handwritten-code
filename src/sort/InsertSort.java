package sort;

public class InsertSort {
	public static void sort(Comparable[] a) {
		if(a == null || a.length == 0)
			return;
		for(int i = 1; i <= a.length-1; i++) {
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				swap(a, j, j-1);
			}
		}
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	private static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
