package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
	public static void sort(Comparable[] a) {
		List<Comparable> l = Arrays.asList(a);
		Collections.shuffle(l);
		a = l.toArray(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo)
			return;
		int p = partition(a, lo, hi);
		sort(a, lo, p-1);
		sort(a, p+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j  = hi + 1;
		while(true) {
			while(less(a[++i], a[lo])) {
				if(i >= hi) break;
			}
			while(less(a[lo], a[--j])) {
				if(j <= lo) break;
			}
			if(i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
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
