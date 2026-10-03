class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0] , v = edges[i][1];
            adj.get(v).add(u);
        }
        int[]indegree = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i= 0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int index = 0;
        int[]result = new int[numCourses];
        while(!q.isEmpty()){
            int vertex = q.poll();
            result[index++] = vertex;
            for(int neigh : adj.get(vertex)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.offer(neigh);
                }
            }

        }
        if(index!=numCourses){
            return false;
        }
        return true;
    }
}