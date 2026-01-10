class Solution {
    public int findCircleNum(int[][] adjmatrix){
        int n = adjmatrix.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,adjmatrix,visited);
                count++;
            }
        }
        return count;
        
    }
    
    public void dfs(int start,int[][]adj,boolean[]visited){
        visited[start] = true;
        for(int i = 0;i<adj.length;i++){
            if(!visited[i]&& adj[start][i]==1){
                dfs(i,adj,visited);
            }
        }
    }
    }
