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
        if(root==null) return 0;
        int lst = levels(root.left);
        int rst = levels(root.right);
        return 1 + Math.max(lst,rst);
    }
    public void bfslevelsum(TreeNode root,List<Long> ans){
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            int size = q.size();
            long sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode front = q.remove();
                sum += front.val;
                if(front.left!=null) q.add(front.left);
                if(front.right!=null)q.add(front.right);
            }
            ans.add(sum);


        }
}
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ans = new ArrayList<>();
        bfslevelsum(root,ans);
                if(k>levels(root)) return -1;

        long[] arr = new long[ans.size()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = ans.get(i);
        }
        int n = arr.length;
        Arrays.sort(arr);
        long val = arr[n-k];
        return val;
        
    }
}