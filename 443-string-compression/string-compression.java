class Solution {
    public int compress(char[] chars) {
        // inplace using two pointer 
        int read = 0,write = 0;
        while(read<chars.length){
            char current = chars[read];
            int count = 0;
            while(read<chars.length && current == chars[read]){
                read++;
                count++;
            }
            chars[write++] = current;
            if(count>1){
                String countstr = String.valueOf(count);
                for(char c : countstr.toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}