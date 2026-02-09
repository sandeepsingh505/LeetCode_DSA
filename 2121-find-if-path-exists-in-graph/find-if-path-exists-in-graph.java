class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int a = edges[i][0],b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[]visited = new boolean[n];
        bfs(source,adj,visited);
        return visited[destination];
        
    }
    public void bfs(int start,ArrayList<ArrayList<Integer>> adj,boolean[]visited){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(q.size()>0){
            int top = q.remove();
            for(int ele : adj.get(top)){
                if(!visited[ele]){
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }
}