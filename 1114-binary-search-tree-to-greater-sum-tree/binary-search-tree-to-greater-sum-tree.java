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
    static int sum;
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.right);
        root.val += sum;
        sum = root.val;
        inorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return null;
        sum = 0;
        inorder(root);
        return root;
        
    }
}