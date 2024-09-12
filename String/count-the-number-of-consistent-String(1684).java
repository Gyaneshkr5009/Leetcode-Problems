//time complexity:O(n*n)+;
//space complexity:O(1);
//*************************************************************************************************************
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        if(words==null || words.length==0) return 0;
        int[] character=new int[26];
        for(char c: allowed.toCharArray()) character[c-'a']=1;


        int cnt=0;
        for(String s:words){
            cnt++;
            for(char c:s.toCharArray()){
                if(character[c-'a']==0){
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}
