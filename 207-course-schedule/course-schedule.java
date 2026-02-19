class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<num;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<pre.length;i++){
            int u = pre[i][0] , v = pre[i][1];
            adj.get(v).add(u);
        }
        int[]indegree = new int[num];
        for(int i = 0;i<num;i++){
            for(int ele : adj.get(i)){
                indegree[ele]++;
            }
        }ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<num;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(q.size()>0){
            int node = q.poll();
            ans.add(node);
            for(int ele : adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }
        if(ans.size()==num) return true;
        return false;
   }
}