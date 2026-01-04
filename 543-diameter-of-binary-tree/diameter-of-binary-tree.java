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
    static int maxdia;
    public int level(TreeNode root){
        if(root==null) return 0;
        int lst = level(root.left);
        int rst = level(root.right);
        int dia = lst + rst;
        maxdia = Math.max(maxdia,dia);
        return  1 + Math.max(lst,rst);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxdia = 0;
        level(root);
        return maxdia;
      
        

        
    }
}