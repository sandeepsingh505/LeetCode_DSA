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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        // step:1 finding the value of key 
        if(root.val > key){
            // matlb lst mein lie krti hai
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else {    // root.val == key
              // handling case for 0 and 1 child
              if(root.left==null){
                return root.right;
              }else if(root.right==null){
                return root.left;
              }else{
                // handling case 3 : 2 child
                int successor = minval(root.right);
                root.val = successor;
                root.right = deleteNode(root.right,successor);
              }
             
              }
              return root;
        }
        public int minval(TreeNode root){
            while(root.left!=null){
                root = root.left;
            }
            return root.val;
        }

}