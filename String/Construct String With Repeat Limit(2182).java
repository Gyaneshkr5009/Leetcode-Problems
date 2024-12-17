class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        if(s==null || s.length()==0) return "";
        int n =s.length();

        //storing the frequency of all characters;
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        int i=25;
        while(i>=0){
            if(freq[i]==0){
                i--;
                continue;
            }
            char ch=(char)('a'+i);
            int count=Math.min(freq[i] , repeatLimit);
            for(int k=0 ;k < count ;k++){
                sb.append((char)(i+'a'));
            }
            freq[i]-=count;

            if(freq[i]>0){
                int j=i-1;
                while(j>=0 && freq[j]==0) j--;
                if(j<0) break;
                sb.append((char)(j+'a'));
                freq[j]--;
            }
        }
        return sb.toString();
    }
}
