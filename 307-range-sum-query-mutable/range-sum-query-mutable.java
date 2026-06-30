class NumArray {
int[]seg;
int n ;
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(nums,0,0,n-1);
    }
    public void build(int[]arr,int i,int s,int e){
        if(s==e){
            seg[i] = arr[s];
            return;
        }
        int mid = (s+e)/2;
        build(arr,2*i+1,s,mid);
        build(arr,2*i+2,mid+1,e);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public void updatetree(int idx , int val ,int i,int s,int e){
        if(s==e){
            seg[i] = val;
            return;
        }
        int mid = (s+e)/2;
        if(idx<=mid){
            updatetree(idx,val,2*i+1,s,mid);
        }else{
            updatetree(idx,val,2*i+2,mid+1,e);
        }
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public void update(int index, int val) {
        updatetree(index,val,0,0,n-1);
    }
    public int query(int i,int s,int e,int l , int r){
        if(r<s|| e < l ) return 0;
        if(l<=s && e<=r) return seg[i];
        int mid = (s+e)/2;
        int left = query(2*i+1,s,mid,l,r);
        int right = query(2*i+2,mid+1,e,l,r);
        return left + right;
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */