class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0 ;
        for(int j=0 ;j < str1.length() ;j++){
            if(i<str2.length() && (str1.charAt(j)==str2.charAt(i) || str1.charAt(j)+1==str2.charAt(i) || str1.charAt(j)-25==str2.charAt(i))) i++;
        }
        return i==str2.length()?true : false;
    }
}a
