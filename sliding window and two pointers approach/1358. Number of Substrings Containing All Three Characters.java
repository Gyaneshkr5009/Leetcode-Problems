class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int cnt=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        while(r<s.length()){
            mpp.put(s.charAt(r) , mpp.getOrDefault(s.charAt(r), 0) +1); //stores all charaters in hashmap
            // now while loop to check that have we got at least a,b,c; if yess then we can add all the rest element as a substring
            while(mpp.getOrDefault('a' ,0)>=1 && mpp.getOrDefault('b' ,0)>=1 && mpp.getOrDefault('c' , 0)>=1){
                // here we got all element so we can consider rest to be as a substring 
                cnt+=s.length()-r;
                // after that we shift left element and check again that we have all element or not & yess we have to remove the value by 1 everytime we move left by one 
                mpp.put(s.charAt(l) , mpp.get(s.charAt(l))-1);
                l++;
            }
            r++;
        }
        return cnt;
    }
}
