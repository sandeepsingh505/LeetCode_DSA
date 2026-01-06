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
    // static int sum;
    public void inorder(TreeNode root,int[] sum ){
        if(root==null) return ;
        inorder(root.right,sum);
        root.val += sum[0];
        sum[0] = root.val;
        inorder(root.left,sum);
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return null;
        int[] sum = {0};
        inorder(root,sum);
        return root;
        
    }
}