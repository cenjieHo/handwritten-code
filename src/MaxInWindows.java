import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
    	ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size < 1 || size > num.length)
        	return res;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < size; i++) {
        	if(queue.isEmpty()) {
        		queue.addLast(num[i]);
        	} else {
        		while(!queue.isEmpty() && num[i] > queue.getLast()) {
        			queue.removeLast();
        		}
        		queue.addLast(num[i]);
        	}
        }
        res.add(queue.getFirst());
        for(int i = 0, j = size; j < num.length;) {
        	if(num[i] == queue.getFirst()) {
        		queue.removeFirst();
        	}
        	i++;
    		while(!queue.isEmpty() && num[j] > queue.getLast()) {
    			queue.removeLast();
    		}
    		queue.addLast(num[j]);
    		res.add(queue.getFirst());
    		j++;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	MaxInWindows solution = new MaxInWindows();
    	int[] num = {2, 3, 1, 5, 6, 4};
    	int size = 6;
    	List<Integer> res = solution.maxInWindows(num, size);
    	for(int i : res) {
    		System.out.print(i + " ");
    	}
    }
}

/**
[2, 3, 1], 5, 6, 4    max: 3
2, [3, 1, 5], 6, 4    max: 5
2, 3, [1, 5, 6], 4    max: 6
2, 3, 1, [5, 6, 4]    max: 6
*/


