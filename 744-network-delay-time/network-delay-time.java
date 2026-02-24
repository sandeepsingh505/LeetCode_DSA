class Solution {
    class Pair{
        int node , time;
        Pair(int node ,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] edges, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int from = edges[i][0] , to = edges[i][1] , wt = edges[i][2];
            adj.get(from).add(new Pair(to,wt));
            
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.time,b.time));
        pq.add(new Pair(k,0));
        while(pq.size()>0){
            Pair p = pq.poll();
            int node = p.node;
            int ti = p.time;
            for(Pair ele : adj.get(node)){
                int next = ele.node;
                int nexti = ele.time;
                if(ti + nexti < distance[next]){
                    distance[next] = ti + nexti;
                    pq.add(new Pair(next,distance[next]));
                }
            }
        }
        int min = 0;
        for(int i = 1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE) return -1;
            min = Math.max(min,distance[i]);
        }
        return min;
    }
}