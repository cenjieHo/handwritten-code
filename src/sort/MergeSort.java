package sort;

public class MergeSort {
	public static void sort(Comparable[] a) {
		if(a == null || a.length == 0)
			return;
		Comparable[] t = new Comparable[a.length];
		sort(a, t, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, Comparable[] t, int lo, int hi) {
		if(hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, t, lo, mid);
		sort(a, t, mid+1, hi);
		merge(a, t, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] t, int lo, int mid, int hi) {
		if(hi <= lo)
			return;
		for(int i = lo; i <= hi; i++) {
			t[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) 		a[k] = t[j++];
			else if(j > hi)		a[k] = t[i++];
			else if(less(t[i], t[j])) a[k] = t[i++];
			else a[k] = t[j++];
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
