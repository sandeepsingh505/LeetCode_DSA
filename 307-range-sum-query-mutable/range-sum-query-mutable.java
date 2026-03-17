class NumArray {
    int seg[];
    int n ;
    public void build(int i,int left ,int right,int[]arr){
        if(left==right){
            seg[i] = arr[left];
            return;
        }
        int mid = left +(right-left)/2;
        build(2*i+1,left,mid,arr);
        build(2*i+2,mid+1,right,arr);
        seg[i] = seg[2*i+1] + seg[2*i+2];
    }
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(0,0,n-1,nums);
        
    }
public void myupdate(int i,int start,int end,int index,int val){
    if(start==end){
         seg[i] = val;
         return;
    }
    int mid = start +(end-start)/2;
    if(index<=mid){
        myupdate(2*i+1,start,mid,index,val);
    }else{
        myupdate(2*i+2,mid+1,end,index,val);
    }
    seg[i] = seg[2*i+1] + seg[2*i+2];
}
    public void update(int index, int val) {
     myupdate(0,0,n-1,index,val);
    }
    public int query(int i,int start,int end,int l,int r){
        // case1 out of bound
        if(end<l || r<start){
            return 0;
        }
        // case2 complete inside 
        if(l<=start && end<=r){
             return seg[i];
        }
        // case3 partial inside
        int mid = start +(end-start)/2;
        int left = query(2*i+1,start,mid,l,r);
        int right = query(2*i+2,mid+1,end,l,r);
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