class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i] = new ArrayList<>();

        for(int[] d : dislikes){
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!bfs(i, graph, color))
                    return false;
            }
        }
        return true;
    }
    boolean bfs(int node, List<Integer>[] graph, int[] color){

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=0;

        while(!q.isEmpty()){

            int cur=q.poll();

            for(int nei: graph[cur]){
                if(color[nei]==-1){
                    color[nei]=1-color[cur];
                    q.add(nei);
                }
                else if(color[nei]==color[cur])
                    return false;
            }
        }
        return true;
    }
}
