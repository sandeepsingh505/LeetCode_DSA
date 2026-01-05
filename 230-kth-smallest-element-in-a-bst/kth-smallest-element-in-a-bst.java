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
    public void inorder(TreeNode root,int k , List<Integer> ans){
        if(root==null) return ;
        inorder(root.left,k,ans);
        ans.add(root.val);
        inorder(root.right,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        List<Integer> ans = new ArrayList<>();
        inorder(root,k,ans);
        return ans.get(k-1);
        
    }
}