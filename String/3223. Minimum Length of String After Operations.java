class Solution {
    public int minimumLength(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();
        int length=n;
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=1;i<n-1;i++){
            char ch=s.charAt(i);
            if(freq[ch-'a']>=3){
                length-=2;
                freq[ch-'a']-=2;
            } 
        }
        return length;
    }
}
//********************************************************************************************************
class Solution {
    public int minimumLength(String s) {
        if(s==null || s.length()==0) return 0;
        int length=0;
        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i:freq){
            if(i==0) continue;
            if(i%2==0) length+=2;
            else length+=1;
        }
        return length;
    }
}
