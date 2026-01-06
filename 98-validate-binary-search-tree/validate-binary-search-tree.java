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
    public static long min(TreeNode root){
    if(root==null) return Long.MAX_VALUE;
    Long leftmin = min(root.left);
    Long rightmin = min(root.right);
    if(rightmin<=root.val) flag = false;
    return Math.min(root.val,Math.min(leftmin,rightmin));
   
}
public static long max(TreeNode root){
    if(root==null) return Long.MIN_VALUE;
    Long leftmax = max(root.left);
    if(leftmax>=root.val) flag = false;
    Long rightmax = max(root.right);
    return Math.max(root.val,Math.max(leftmax,rightmax));
    
}
    // method 1 : inorder se 
    // public void inorder(TreeNode root,List<Integer> ans){
    //     if(root==null) return ;
    //     inorder(root.left,ans);
    //     ans.add(root.val);
    //     inorder(root.right,ans);
    // }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
    //    List<Integer> ans = new ArrayList<>();
    //    inorder(root,ans);
    //    for(int i = 1;i<ans.size();i++){
    //     if(ans.get(i)<= ans.get(i-1)) return false;
    flag = true;
    max(root);
    min(root);
    return flag;
    }
}