class Solution {
    public int countSquares(int[][] grid) {
        int count = 0;
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0)continue;
                    if(i>0 && j>0){
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j-1],Math.min(grid[i-1][j],grid[i][j-1]));
                  }
                  count += grid[i][j];
                }
            }
              return count;

        }
       
    }
