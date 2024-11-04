class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();

        int cnt=1;
        for(int i=1;i < word.length() ; i++){
            char curr=word.charAt(i);
            char prev=word.charAt(i-1);
            if(prev==curr){
                cnt++;
                if(cnt==9){
                    sb.append(cnt).append(curr);
                    cnt=0;
                }
            }
            else {
                if(cnt!=0) sb.append(cnt).append(prev);
                cnt=1;
            }
        }
        if(cnt!=0) sb.append(cnt).append(word.charAt(word.length()-1));

        return sb.toString();
    }
}
//**********************************************************(optimised approach)*******************************************************
//time complexity:O(n):space complexity;
class Solution {
    public String compressedString(String word) {
        int n=word.length();
        StringBuilder sb=new StringBuilder();
        int i=0;

        while(i<n){
            int cnt=0;
            char ch=word.charAt(i);

            while(i<n && cnt<9 && ch==word.charAt(i)){
                cnt++;
                i++;
            }
            sb.append(cnt).append(ch);
        }
        return sb.toString();
    }
}
