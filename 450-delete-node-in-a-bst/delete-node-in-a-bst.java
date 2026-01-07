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
    // using predecessor method 
    public int maxval(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val> key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                int pred = maxval(root.left);
                root.val = pred;
                root.left = deleteNode(root.left,pred);
            }
        }
        return root;
        
    }
}