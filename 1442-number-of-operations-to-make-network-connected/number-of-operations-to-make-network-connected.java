class Solution {
    public void bfs(int start,boolean visited[],ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q = new LinkedList<>();
       visited[start] = true;
       q.add(start);
       while(q.size()>0){
        int node = q.poll();
        for(int ele : adj.get(node)){
            if(!visited[ele]){
                visited[ele] = true;
                q.add(ele);
            }
        }
       }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<connections.length;i++){
            int from = connections[i][0] , to = connections[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        int operations  = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(i,visited,adj);
                operations++;
            }
        }
        return (operations ==0)? -1 : operations-1;
        
    }
}