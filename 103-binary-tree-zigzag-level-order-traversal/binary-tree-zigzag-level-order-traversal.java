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
       class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node , int level){
            this.node = node;
            this.level = level;
        }
    }
    public int levels(TreeNode root){
        if(root==null)return 0;
        int lst = levels(root.left);
        int rst = levels(root.right);
        return 1 + Math.max(lst,rst);
    }
    public void BFS(TreeNode root,List<List<Integer>> ans){
        Queue<Pair> q  = new LinkedList<>();
        if(root!=null) q.add(new Pair(root,0));
        while(q.size()>0){
            Pair front = q.remove();  // abb yeha se do cheje nikali hai (node , lvl);
            TreeNode  temp = front.node;
            int lvl = front.level;
             if (ans.size() == lvl) ans.add(new LinkedList<>());
            if(lvl%2==0){
            ans.get(lvl).add(temp.val);
            }
            else{
            ans.get(lvl).add(0,temp.val);
            }
            if(temp.left!=null) q.add(new Pair(temp.left,lvl+1));
            if(temp.right!=null) q.add(new Pair(temp.right,lvl+1));


            


        }
    }
  
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i = 0;i<lvl;i++){
            List<Integer> arr = new ArrayList<>();
            ans.add(arr);
        }
        BFS(root,ans);
        return ans;
    }
}