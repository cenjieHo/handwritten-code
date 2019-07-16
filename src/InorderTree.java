import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTree {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	TreeNode node = root;
    	Stack<TreeNode> stack = new Stack<>();
    	while(node != null && !stack.isEmpty()) {
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		node = stack.pop();
    		res.add(node.val);
    		node = node.right;
    	}
    	return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}