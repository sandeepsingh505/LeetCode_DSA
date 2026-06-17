class Solution {
    class Pair{
        int row, col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void bfs(int sr,int sc,int oldcolor , int newcolor,int[][]grid){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        grid[sr][sc] = newcolor;
        int[][]directions = {{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size()>0){
            Pair p = q.poll();
            for(int[]d : directions){
                int nr = p.row  + d[0];
                int nc = p.col + d[1];
                if(nr>=0 && nc >= 0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==oldcolor){
                    grid[nr][nc] = newcolor;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        if(oldcolor==color) return image;
        bfs(sr,sc,oldcolor,color,image);
        
        return image;
    }
}