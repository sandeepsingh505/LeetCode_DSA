class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
       boolean visited[] = new boolean[n];
       visited[0] = true;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(0,adj,visited);
            }
        }
        
        for(boolean ele : visited){
            if(ele==false) return false;
        }
        return true;
    }
    public void bfs(int start,List<List<Integer>> adj,boolean[]visited){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(q.size()>0){
            int top = q.remove();
            for(int ele: adj.get(top)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
    }
}