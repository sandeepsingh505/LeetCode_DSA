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
    
    public TreeNode construct(int[] inorder, int[] postorder,int instart,int inEnd,int poststart,int postEnd){
        if(instart>inEnd||poststart>postEnd) return null;
        int n = postorder.length;
        int rootval = postorder[postEnd];
        TreeNode root = new TreeNode(rootval);
        int k = instart;
        while(inorder[k]!=rootval)k++;
        int leftsize = k-instart;
        root.left = construct(inorder,postorder,instart,k-1,poststart,poststart+leftsize-1);
        root.right = construct(inorder,postorder,k+1,inEnd,poststart + leftsize ,postEnd-1);

        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        return construct(inorder,postorder,0,n-1,0,n-1);
        
    }
}