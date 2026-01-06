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
    public TreeNode inorderbst(int[]preorder,int[]inorder,int ps,int pEnd,int istart,int iEnd){
        if(ps>pEnd || istart>iEnd) return null;
        int rootval = preorder[ps];
        TreeNode root = new TreeNode(rootval);
        int k = istart;
        while(inorder[k]!=rootval) k++;
        int leftsize = k-istart;
        root.left = inorderbst(preorder,inorder,ps+1,ps+leftsize,istart,k-1);
        root.right = inorderbst(preorder,inorder,ps+leftsize+1,pEnd,k+1,iEnd);
        return root;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[]inorder = new int[n];
        for(int i = 0;i<n;i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
       return  inorderbst(preorder,inorder,0,n-1,0,n-1);
        
    }
}