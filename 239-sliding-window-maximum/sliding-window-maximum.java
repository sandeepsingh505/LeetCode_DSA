class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int i = 0 , j = 0;
        int max = 0;
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(j<arr.length){
         while(q.size()>0 && q.peekLast()<arr[j]){
            q.removeLast();
    }
         q.addLast(arr[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                list.add(q.peek());
                if(q.peekFirst()==arr[i]) q.removeFirst();
                i++;
                j++;
            }
        }
        int [] ans = new int[list.size()];
     for(int m = 0;m<list.size();m++){
        ans[m] = list.get(m);
     }
     return ans;

    }
}