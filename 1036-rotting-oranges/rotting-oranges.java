class Solution {
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int bfs(int r,int c,int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int minute = 0 , fresh = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int [][]direction = {{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size()>0 && fresh>0){
            int size = q.size();
            minute++;
            for(int i = 0;i<size;i++){
                Pair p = q.poll();
                boolean rottanlevel = false;
                for(int[]d : direction){
                    int nr = p.row + d[0];
                    int nc = p.col + d[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        rottanlevel = true;
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new Pair(nr,nc));

                    }
                }
            }
            
        }
        if(fresh==0) return minute;
        return -1;
    }
    public int orangesRotting(int[][] grid) {
        return bfs(0,0,grid);
    }
}