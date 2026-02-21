import java.util.*;

class Solution {

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        // build graph
        for(int[] p : pairs){
            adj.computeIfAbsent(p[0], k -> new ArrayDeque<>()).add(p[1]);
            outdeg.put(p[0], outdeg.getOrDefault(p[0],0)+1);
            indeg.put(p[1], indeg.getOrDefault(p[1],0)+1);
        }

        // find start node
        int start = pairs[0][0];
        for(int node : adj.keySet()){
            if(outdeg.getOrDefault(node,0) -
               indeg.getOrDefault(node,0) == 1){
                start = node;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        dfs(start, adj, path);

        Collections.reverse(path);

        int[][] ans = new int[pairs.length][2];
        for(int i=0;i<pairs.length;i++){
            ans[i][0] = path.get(i);
            ans[i][1] = path.get(i+1);
        }

        return ans;
    }

    void dfs(int u, Map<Integer,Deque<Integer>> adj,
             List<Integer> path){

        Deque<Integer> dq = adj.get(u);

        while(dq != null && !dq.isEmpty()){
            int v = dq.poll();
            dfs(v, adj, path);
        }

        path.add(u);
    }
}