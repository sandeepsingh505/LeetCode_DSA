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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        // agar root ki value choti hai low se toh right jao not to go on left
        if(low>root.val) return rangeSumBST(root.right ,low,high);
        // agar root ki value bade hai high se toh mtlb humme left jana hai 
        if(high<root.val) return rangeSumBST(root.left,low,high);
        // agar low<= root.val<= high toh dono taraf search kro
        
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        
    }
}