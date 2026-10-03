class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor = image[sr][sc];
        if(originalcolor==color){
            return image;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        int[][]direction = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[]nd = q.poll();
            for(int[]dir : direction){
                int nr = dir[0] + nd[0];
                int nc = dir[1] + nd[1];
                if(nr>=0 && nr<image.length && nc>=0 && nc < image[0].length  && image[nr][nc]==originalcolor){
                    image[nr][nc] = color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}