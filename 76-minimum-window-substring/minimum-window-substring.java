class Solution {
    public String minWindow(String s, String t) {
        int i=0,j = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count = map.size();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            if(count>0){
                j++;
                
            }else if(count==0){
                 while(count==0){
                   if(j-i+1<min){
                    min = j-i+1;
                    start = i;
                }
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0){
                        count++;
                    }

                    }
                    i++;
                }
                j++;
            }
            }
            if(min==Integer.MAX_VALUE) return "";
        return s.substring(start,start+min);
        }
        
    }
