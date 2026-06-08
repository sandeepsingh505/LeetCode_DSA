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
    static boolean flag;
    public Long max(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        Long leftmax = max(root.left);
        if(leftmax>= root.val) flag = false;
        Long rightmax = max(root.right);
        return Math.max(root.val,Math.max(leftmax,rightmax));
    }
    public Long min(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        Long leftmin = min(root.left);
        Long rightmin = min(root.right);
        if(rightmin <= root.val) flag = false;
        return Math.min(root.val,Math.min(leftmin,rightmin));
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        max(root);
        min(root);
        return flag;
    }
}