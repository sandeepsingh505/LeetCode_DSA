class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
      int min = Integer.MAX_VALUE;

     
     HashMap<String,Integer> map=new HashMap<>();
     for(int i = 0;i<list1.length;i++){
        for(int j = 0;j<list2.length;j++){
            if(list1[i].equals(list2[j])){

                map.put(list1[i],i+j);

                min=Math.min(min,i+j);



            }
        }
     }

     ArrayList<String> ans=new ArrayList<>();

     for(String key:map.keySet()){

        if(map.get(key)==min){
            ans.add(key);
        }
     }

     String arr[]=new String[ans.size()];
     for(int i=0;i<ans.size();i++){
        arr[i]=ans.get(i);
     }

     return  arr;



        
    }
}