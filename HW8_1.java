import java.util.*;
public class HW8_1 {
    public static void main(String[] args) {

        // create a solution instance
        Solution sol = new Solution();

        // create a random binary tree of your choice
        BSTNode tree = new BSTNode(0);
        tree = new BSTNode(0);
        tree = new BSTNode(0);

        System.out.println(sol.distribute(tree)); // 2

        BSTNode tree2 = new BSTNode(0);
        tree2.left = new BSTNode(0);
        tree2.left.left = new BSTNode(0);
        tree2.left.left.left = new BSTNode(0);
        tree2.left.left.left.left = new BSTNode(5);
        tree2.right = new BSTNode(1);

        System.out.println(sol.distribute(tree2)); // 10
    }
}

// ===============================================
// DO NOT MODIFY TREE BELOW THIS LINE
// ===============================================

class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;
    BSTNode(int x) {
        val = x;
    }
}
// ===============================================
// DO NOT MODIFY TREE ABOVE THIS LINE
// ===============================================

class Solution {

    int answer;

    /**
     * PURPOSE: calls dfs method 
     * PARAMETERS: BSTNode tree
     * RETURN VALUES: int answer 
     */

    public int distribute(BSTNode tree) {
        dfs(tree);
        int answer = this.answer;
        this.answer = 0;
        return answer;
    }

    /**
     * PURPOSE: distributes numbers equally among the tree and count the result
     * PARAMETERS: BSTNode root
     * RETURN VALUES: int answer if not null / 0 if null
     */

    public int dfs(BSTNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        answer += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}