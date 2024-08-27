//time complexity:O(n);
//space complexity:O(1);

//approach => we iterate through str1 and stored frequency of all string then iterate through str2 and decrement the frequency of character in array map if all value (zero) ? true:false;
//****************************************************************************************************************************************************
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int count[]=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            count[ch-'a']--;
        }

        for(int val:count){
            if(val!=0) return false;
        }

        return true;
    }
}

//*************************************************************(normal approach)************************************************************
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> mpp=new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i=0 ;i<s.length() ;i++){
            mpp.put(s.charAt(i) , mpp.getOrDefault(s.charAt(i) , 0)+1);
        }
        for(char n:t.toCharArray()){
            if(!mpp.containsKey(n) || mpp.get(n)==0) return false;
            mpp.put(n , mpp.get(n)-1);
        }
        return true;
    }
}
