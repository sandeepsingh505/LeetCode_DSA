class Solution {
    public void bfs(int start,List<List<Integer>> adj,boolean[]visited){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(q.size()>0){
            int top = q.poll();
            for(int ele : adj.get(top)){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[]visited = new boolean[n];
        visited[0] = true;
          bfs(0,rooms,visited);
      for(boolean ele : visited){
        if(ele == false) return false;
      }
      return true;
    }
}