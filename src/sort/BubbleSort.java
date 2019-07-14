package sort;

public class BubbleSort {
	public static void sort(Comparable[] a) {
		if(a == null || a.length == 0)
			return;
		for(int i = a.length - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				if(less(a[j+1], a[j])) swap(a, j, j+1);
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
