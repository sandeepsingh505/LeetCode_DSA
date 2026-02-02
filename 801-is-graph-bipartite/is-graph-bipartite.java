class Solution {
    static boolean ans;
    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[]visited = new int[n];
        Arrays.fill(visited,-1);
        for(int i = 0;i<n;i++){
            if(ans == false ) return ans;
            else if(visited[i]==-1) bfs(i,graph,visited);
        }
        return ans;
    }
    public void bfs(int start,int[][]graph, int[]visited){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 0;   // 0- red , 1 - blue;
        q.add(start);
        while(q.size()>0) {
            int front = q.poll();
            int color = visited[front];
            for(int ele : graph[front]){
                if(visited[ele]==visited[front]){
                    ans = false;
                    return ;
                }
                if(visited[ele]==-1){
                    visited[ele] = 1-color;
                    q.add(ele);
                }
            }
        }
    }
}