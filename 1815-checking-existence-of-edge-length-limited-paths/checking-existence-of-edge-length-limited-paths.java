class Solution {
    static int[]parent ;
    static int[] rank;
    public int find(int i){
        if(i==parent[i]) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa==pb) return ;
        if(rank[pa]<rank[pb]){
            parent[pa] = pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
            rank[pb] ++;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++) parent[i] = i;
        Arrays.sort(edgeList,(a,b)->Integer.compare(a[2],b[2]));
        int[][] q = new int[queries.length][3];
        for(int i = 0;i<q.length;i++){
            q[i]  = new int[]{queries[i][0],queries[i][1],queries[i][2],i};
        }
        boolean[] res = new boolean[queries.length];
        Arrays.sort(q,(a,b)->Integer.compare(a[2],b[2]));
        int j = 0;
        for(int i = 0;i<q.length;i++){
            int p = q[i][0];
            int qv = q[i][1];
            int limit = q[i][2];
            int idx = q[i][3];
            while(j<edgeList.length && edgeList[j][2]<limit){
              int u =   edgeList[j][0] , v = edgeList[j][1];
            union(u,v);
            j++;
            }
            if(find(p)==find(qv)){
                res[idx] = true;

            }else{
                res[idx] = false;
            }
        }
        
       return res;
        
    }
}