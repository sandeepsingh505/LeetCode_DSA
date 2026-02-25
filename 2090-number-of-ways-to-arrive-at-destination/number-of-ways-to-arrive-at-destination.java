class Solution {
    class Pair {
        int node;
        long weight;
        Pair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int MOD = 1000000007;
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
 while (!pq.isEmpty()) {
        Pair p = pq.poll();
        int node = p.node;
        long weight = p.weight;
    if (weight > dist[node]) continue;
        for (Pair ele : adj.get(node)) {
            int next = ele.node;
            long nextwt = ele.weight;
            long newDist = weight + nextwt;
     if (newDist < dist[next]) {
             dist[next] = newDist;
        ways[next] = ways[node];
         pq.add(new Pair(next, newDist));
         }else if (newDist == dist[next]) {
                 ways[next] = (ways[next] + ways[node]) % MOD;
     }
    }
        }
 return (int)(ways[n - 1] % MOD);
    }
}