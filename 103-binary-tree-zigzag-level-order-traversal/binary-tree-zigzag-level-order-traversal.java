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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);
        boolean lefttoRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode  nd = q.remove();
                list.add(nd.val);
                if(nd.left!=null) q.add(nd.left);
                if(nd.right!=null)q.add(nd.right); 

            }
              if(!lefttoRight){
                    Collections.reverse(list);
                }
            ans.add(list);
            lefttoRight = !lefttoRight;
        }
        return ans;
    }
}