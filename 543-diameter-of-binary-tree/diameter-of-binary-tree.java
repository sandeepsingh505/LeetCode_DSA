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
    public int level(TreeNode root){
        if(root==null) return 0;
        int lst = level(root.left);
        int rst = level(root.right);
        return  1 + Math.max(lst,rst);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int mydia = level(root.left) + level(root.right);
        int lstdia = diameterOfBinaryTree(root.left);
        int rstdia = diameterOfBinaryTree(root.right);
        return Math.max(mydia,Math.max(lstdia,rstdia));
        

        
    }
}