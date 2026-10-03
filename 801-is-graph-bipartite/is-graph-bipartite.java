class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i,color,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node,int[]color,int[][]graph){
        color[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int vertex = q.poll();
            for(int val :graph[vertex]){
                if(color[val] == -1){
                    color[val] = 1-color[vertex];
                    q.offer(val);
                }else if(color[val]==color[vertex]){
                    return false;
                }
            }
        }
        return true;
    }
}