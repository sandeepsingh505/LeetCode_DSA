class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
    
    if(start==end) return true;
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i = 0;i<edges.length;i++){
        int a = edges[i][0], b = edges[i][1];
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
     boolean visited[] = new boolean[n];
     visited[start] = true;
    dfs(start,adj,visited);
        
     return visited[end];
    }

    public void dfs(int start,List<List<Integer>> adj,boolean[]visited){
       visited[start] = true;
       for(int ele : adj.get(start)){
        if(!visited[ele]) dfs(ele,adj,visited);
       } 
}
}