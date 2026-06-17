class Solution {
public void bfs(int start,ArrayList<ArrayList<Integer>> adj, boolean[]visited){
    Queue<Integer> q = new LinkedList<>();
    visited[start] = true;
    q.add(start);
    while(q.size()>0){
        int node = q.poll();
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                visited[neigh] = true;
                q.add(neigh);
            }
        }
    }
}
    public int findCircleNum(int[][] isConnected) {
 ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
 for(int i = 0;i<isConnected.length;i++){
    adj.add(new ArrayList<>());
 }
 for(int i = 0;i<isConnected.length;i++){
    for(int j = 0;j<isConnected[0].length;j++){
        if(isConnected[i][j]==1){
            adj.get(i).add(j);
            adj.get(j).add(i);
        }
    }
 }
    int count = 0;
    boolean visited[] = new boolean [isConnected.length];
    for(int i = 0;i<adj.size();i++){
        if(!visited[i]){
            bfs(i,adj,visited);
            count++;
        }
    }

 return count;
        
    }
}