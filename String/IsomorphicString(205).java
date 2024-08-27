// time complexity:O(N);
//space complexity:O(1);
//approach => we try to link all characters of str1 string to str2 string , during iteration we cross by looking into each other hashmap values if got different return false;
//************************************************************************************************************************************************
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        else{
            HashMap<Character,Character> Schar=new HashMap<>(26);
            HashMap<Character,Character> Tchar=new HashMap<>(26);

            for(int i=0 ;i<s.length() ;i++){
                char s1=s.charAt(i);
                char t1=t.charAt(i);
                
                if(Schar.containsKey(s1)){
                    if(Schar.get(s1)!=t1) return false;
                }
                else{
                    Schar.put(s1,t1);
                }

                if(Tchar.containsKey(t1)){
                    if(Tchar.get(t1)!=s1) return false;
                }
                else{
                    Tchar.put(t1,s1);
                }
            }
        }
        return true;
    }
}

//*****************************************************(optimal approach)********************************************************
//time complexity:O(n)
//space complexity:O(1)
//approach we try to store index of all char of two strings to their arrayMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] idx1=new int[256];
        int[] idx2=new int[256];
        for(int i=0 ;i<s.length() ;i++){
            char a=s.charAt(i) , b=t.charAt(i);
            if(idx1[a]!=idx2[b]) return false;
            idx1[a]=i+1;
            idx2[b]=i+1;
        }
        return true;
    }
}
