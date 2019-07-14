package sort;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Integer[] a = SortTestHelper.generateRandomArray(100, 0, 100);
		Integer[] b = a.clone();
		QuickSort.sort(a);
		Arrays.sort(b);
//		System.out.println("测试结果：" + SortTestHelper.isSorted(a));
		System.out.println("测试结果：" + SortTestHelper.isSorted(a, b));
        SortTestHelper.printArray(a);
        SortTestHelper.printArray(b);
	}
}
