
public class MinWindow {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
        	return "";
        int[] map = new int[256];
        int count = t.length();
        for(int i = 0; i < t.length(); i++) {
        	map[t.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        int from = 0;
        int min = Integer.MAX_VALUE;
        for(; j < s.length(); ) {
        	if(map[s.charAt(j)]-- > 0) count--;
        	while(count == 0) {
        		if(j - i < min) {
        			min = j - i;
        			from = i;
        		}
        		if(++map[s.charAt(i)] > 0) count++;
        		i++;
        	}
        	j++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min + 1);
    }
    
    public static void main(String[] args) {
    	MinWindow solution = new MinWindow();
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	System.out.println(solution.minWindow(s, t));
    }
}

/**
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
*/