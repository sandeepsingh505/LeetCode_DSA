class Solution {
    class Pair{
        int row , col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
         int fresh = 0,minutes = 0;
         int n = grid.length , m = grid[0].length;
         for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
         }
         int[][]directions = {{1,0},{0,1},{-1,0},{0,-1}};
         while(q.size()>0){
            int size = q.size();
            boolean rottenthislevel = false;
            for(int i = 0;i<size;i++){
                Pair p = q.poll();
                for(int[]d : directions){
                    int nr = p.row + d[0];
                    int nc = p.col + d[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        rottenthislevel = true;
                        fresh--;
                        q.add(new Pair(nr,nc));

                    }
                }
            }
            if(rottenthislevel) minutes++;
         }
         if(fresh==0) return minutes;
         else return -1;
    }
}