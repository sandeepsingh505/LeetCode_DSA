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
    public int levels(TreeNode root){
        if(root==null)return 0;
        int lst = levels(root.left);
        int rst = levels(root.right);
        return 1 + Math.max(lst,rst);
    }
    public void preorderlevel(TreeNode root,int level,int lvl , List<Integer>ans){
        if(root==null) return ;
        if(level==lvl) ans.add(root.val);
        preorderlevel(root.left,level+1,lvl,ans);
        preorderlevel(root.right,level+1,lvl,ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0;i<lvl;i++){
            List<Integer> arr = new ArrayList<>();
            preorderlevel(root,0,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}