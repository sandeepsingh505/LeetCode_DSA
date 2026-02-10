class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int from = edges[i][0] , to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for(int i = 0;i<adj.size();i++){
            if(adj.get(i).size()==n-1){
                return i;
            }
        }
        return -1;
    }
}