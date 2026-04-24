class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int from = edges[i][0] , to = edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        boolean[]visited = new boolean[n];
        bfs(source,graph,visited);
        return visited[destination]; 
    }
    public void bfs(int start ,ArrayList<ArrayList<Integer>> adj , boolean[]visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
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
}