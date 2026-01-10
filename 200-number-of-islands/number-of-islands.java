class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        boolean[][] visited = new boolean[m][n];
        for(int row = 0;row<m;row++){
            for(int col=0;col<n;col++){
                if(visited[row][col]==false && grid[row][col]=='1'){
                    dfs(row,col,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i ,int j ,char[][]grid,boolean[][]visited){
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        if(i-1>=0 && grid[i-1][j]=='1'&&!visited[i-1][j]) dfs(i-1,j,grid,visited);
        if(i+1<m && grid[i+1][j]=='1'&&!visited[i+1][j]) dfs(i+1,j,grid,visited);
        if(j-1>=0 && grid[i][j-1]=='1'&&!visited[i][j-1]) dfs(i,j-1,grid,visited);
        if(j+1<n && grid[i][j+1]=='1'&&!visited[i][j+1]) dfs(i,j+1,grid,visited);


    }
    
    }
