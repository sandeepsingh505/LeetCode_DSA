class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
       boolean visited[] = new boolean[n];
       visited[0] = true;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(0,adj,visited);
            }
        }
        
        for(boolean ele : visited){
            if(ele==false) return false;
        }
        return true;
    }
   public void dfs(int start,List<List<Integer>> adj,boolean[]visited){
    visited[start] = true;
    for(int ele : adj.get(start)){
        if(!visited[ele]) dfs(ele,adj,visited);
    }
   }
}