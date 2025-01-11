class Solution {
    public int compress(char[] chars) {
        int write=0;
        int i=0 , n=chars.length;
        while(i<n){
            char currentChar=chars[i];
            int count=0;
            while(i<n && currentChar==chars[i]){
                count++;
                i++;
            }
            chars[write++]=currentChar;

            if(count>1){
                for(char ch:Integer.toString(count).toCharArray()){
                    chars[write++]=ch;
                }
            }
        }
        return write;
    }
}
