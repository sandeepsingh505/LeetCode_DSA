class Solution {
    public void dfs(int start,List<List<Integer>> adj,boolean[]visited){
        visited[start] = true;
        for(int ele : adj.get(start)){
            if(!visited[ele]) dfs(ele,adj,visited);
        }
        
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[]visited = new boolean[n];
        visited[0] = true;
          dfs(0,rooms,visited);
      for(boolean ele : visited){
        if(ele == false) return false;
      }
      return true;
    }
}