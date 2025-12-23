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
    static int dia;
    public int height(TreeNode root,Map<TreeNode,Integer> dp){
        if(root==null)return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = height(root.left,dp);
        int right = height(root.right,dp);
        dp.put(root,1 + Math.max(left,right));
        return dp.get(root);
    }
    public int diameter(TreeNode root,Map<TreeNode,Integer> dp){
        if(root==null)return 0;
        int dia = height(root.left,dp) + height(root.right,dp);
        int leftdia = diameter(root.left,dp);
        int rightdia = diameter(root.right,dp);
        return Math.max(dia,Math.max(leftdia,rightdia));
    }
    public int diameterOfBinaryTree(TreeNode root){
         Map<TreeNode,Integer> dp = new HashMap<>();
         return diameter(root,dp);
    }
}