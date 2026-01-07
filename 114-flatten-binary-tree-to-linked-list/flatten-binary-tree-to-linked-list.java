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
    public void preorder(TreeNode root,List<TreeNode> ans){
        if(root==null) return ;
        ans.add(root);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public void flatten(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        preorder(root,ans);
        int n = ans.size();
        for(int i = 0;i<n;i++){
            if(i!=n-1) ans.get(i).right = ans.get(i+1);
            ans.get(i).left = null;
        }
        
    }
}