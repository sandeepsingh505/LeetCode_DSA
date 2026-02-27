class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        int[]dist = new int[n+1];
        Arrays.fill(dist,100000000);
        dist[k] = 0;
        for(int i = 1;i<=n-1;i++){
            for(int j=0;j<edges.length;j++){
               int u = edges[j][0];
               int v = edges[j][1];
               int wt = edges[j][2];
               if(dist[u]!=100000000 && dist[u] + wt < dist[v]){
                   dist[v] = dist[u] + wt;
                   }
            }
        }
        for(int j=0;j<edges.length;j++){
               int u = edges[j][0];
               int v = edges[j][1];
               int wt = edges[j][2];
               if(dist[u]!=100000000 && dist[u] + wt < dist[v]){
                   return -1;
                   }
                   
    }
 int minitime = Integer.MIN_VALUE;
   for(int i = 1;i<=n;i++){
    if(dist[i]==100000000) return -1;
   
    minitime = Math.max(minitime , dist[i]);
   }
   return minitime;
}
}
