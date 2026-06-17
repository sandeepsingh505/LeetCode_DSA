class Solution {
    class Pair {
        int node;
        int cost;
        int stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k) {
        ArrayList<ArrayList<int[]>> adj =
                new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new int[]{v, cost});
        }
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;
            if (stops > k)
                continue;
            for (int[] nbr : adj.get(node)) {

                int nextNode = nbr[0];
                int edgeCost = nbr[1];

                int newCost = cost + edgeCost;

                if (newCost < dist[nextNode]) {

                    dist[nextNode] = newCost;

                    q.offer(
                        new Pair(
                            nextNode,
                            newCost,
                            stops + 1
                        )
                    );
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}