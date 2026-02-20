class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<graph.length;i++){
            for(int ele : graph[i]){
                adj.get(ele).add(i);
            }
        }
            int[]indegree = new int[graph.length];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0;i<graph.length;i++){
                for(int ele  : adj.get(i)) indegree[ele]++;
            }
            for(int i = 0;i<graph.length;i++){
                if(indegree[i]==0)q.add(i);
            }
            ArrayList<Integer> ans = new ArrayList<>();
            while(q.size()>0){
                int node = q.poll();
                ans.add(node);
                for(int ele : adj.get(node)){
                    indegree[ele]--;
                    if(indegree[ele]==0) q.add(ele);
                }
            }
      Collections.sort(ans);
      return ans;
        
    }
}