class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
      int V = edges.length;
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<V;i++){
            adj.add(new ArrayList<>());
        }
       for(int i = 0;i<edges.length;i++){
           for(int ele : edges[i]){
            adj.get(ele).add(i);
           }  
       }
       int[] indegree = new int[V];
       for(int i = 0 ;i<V;i++){
        for(int ele : adj.get(i)){
            indegree[ele]++;
        }
       }
       Queue<Integer> q = new LinkedList<>();
       List<Integer>  ans = new ArrayList<>();
       for(int i = 0;i<V;i++){
        if(indegree[i]==0) q.add(i);
       }
       while(q.size()>0) {
        int node = q.poll();
        ans.add(node);
        for(int neigh: adj.get(node)){
            indegree[neigh]--;
            if(indegree[neigh]==0) q.add(neigh);
        }
       }     
    Collections.sort(ans);
    return ans;    
    }
}