class NumArray {
   int[]seg ;
   int n;
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(0,0,n-1,seg,nums);
    }
    public void build(int i,int start,int end,int[]seg,int[]nums){
        if(start==end){
            seg[i] = nums[start];
            return;
        }
        int mid = start +(end-start)/2;
        build(2*i+1,start,mid,seg,nums);
        build(2*i+2,mid+1,end,seg,nums);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public int query(int i,int start,int end,int l,int r,int[]seg){
        if(end<l || r<start){
            return 0;
        }
        if(l<=start && end <=r){
         return   seg[i];
        }
        int mid = start+(end-start)/2;
        return query(2*i+1,start,mid,l,r,seg) + query(2*i+2,mid+1,end,l,r,seg);
    }
    public int sumRange(int left, int right){
        return query(0,0,n-1,left,right,seg);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */