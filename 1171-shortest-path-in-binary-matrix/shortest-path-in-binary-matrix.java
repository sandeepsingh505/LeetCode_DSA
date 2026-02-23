class Solution {
    class Pair{
        int row , col;
        Pair(int row ,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        Queue<Pair> q = new LinkedList<>();
        int[][]distance = new int[n][n];
        for(int row[]: distance) Arrays.fill(row,-1);
        distance[0][0] = 1;
        q.add(new Pair(0,0));
        grid[0][0]=1;
        int[][]direction = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(q.size()>0){
            int size = q.size();
            for(int i = 0;i<size;i++){
            Pair p = q.poll();
            for(int[]d : direction){
                int nr = p.row + d[0];
                int nc = p.col + d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && distance[nr][nc]==-1 && grid[nr][nc]==0){
                    distance[nr][nc] = distance[p.row][p.col] + 1;
                    grid[nr][nc] =1;
                    q.add(new Pair(nr,nc));
                }
            
            }
            }
        }

    return distance[n-1][n-1];
        
    }
}