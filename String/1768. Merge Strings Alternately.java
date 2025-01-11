//time complexity:O(n);
//space complexity:O(n);
//********************************************************************************
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0,j=0 , n1=word1.length() , n2=word2.length();
        while(i<n1 && j<n2){
            char ch1=word1.charAt(i++);
            char ch2=word2.charAt(j++);
            sb.append(ch1).append(ch2);
        }
        if(i<n1) sb.append(word1.substring(i,n1));
        if(j<n2) sb.append(word2.substring(j,n2));
        return sb.toString();
    }
}
