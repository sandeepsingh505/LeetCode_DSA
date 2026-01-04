/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dfs(TreeNode root,long sum){
        if(root==null) return 0;
        int count = 0;
        if(root.val==sum) count++;
        count+= dfs(root.left,sum-root.val);
        count += dfs(root.right,sum-root.val);
        return count;
    }
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int startingnode = dfs(root,sum);
        int lst = pathSum(root.left,sum);
        int rst = pathSum(root.right,sum);
        return startingnode + lst + rst;
        
    }
}