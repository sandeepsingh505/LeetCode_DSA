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
    public void inorder(TreeNode root,List<TreeNode> ans){
        if(root==null) return ;
        inorder(root.left,ans);
        ans.add(root);
        inorder(root.right,ans);
    }
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> ans  = new ArrayList<>();
        inorder(root,ans);
        int n = ans.size();
        for(int i = n-2;i>=0;i--){
            ans.get(i).val += ans.get(i+1).val;
        }
        return root;
    }
}