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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root!=null)q.add(root);
        while(q.size()>0){
            int size1 = q.size();      // yeh humme batayega ki curr level par kitne nodes hai
            for(int i = 0;i<size1;i++){
                TreeNode temp = q.remove();
                if(i==size1-1){ ans.add(temp.val);}
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);


            }
        }
        return ans;
    }
}