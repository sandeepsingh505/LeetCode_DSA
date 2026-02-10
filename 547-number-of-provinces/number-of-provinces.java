class Solution {
    public int findCircleNum(int[][] matrix) {
        int provinces = 0;
         int n  = matrix.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[]visited = new boolean[n];
    for(int i = 0;i<n;i++){
        if(!visited[i]){
            dfs(i,adj,visited);
            provinces++;
        }
    }
    return provinces;
        
    }
    public void dfs(int start,ArrayList<ArrayList<Integer>> adj, boolean[]visited){
        visited[start] = true;
        for(int ele : adj.get(start)){
            if(!visited[ele]) dfs(ele,adj,visited);
        }
        
    }
}