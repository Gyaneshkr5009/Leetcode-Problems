class Solution {
    int mod=(int)1e9+7;
    public int lengthAfterTransformations(String s, int t) {
        int[] freq=new int[26];
        int ans=0;
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<t ;i++){
            int[] count=new int[26];
            for(int j=0 ; j<26 ;j++){
                if(freq[j] > 0){
                    if(j==25){
                        count[0] = (freq[j] + count[0])%mod;
                        count[1] = (freq[j] + count[1])%mod;
                    }
                    else{
                        count[j+1] = freq[j];
                    }
                }
            }
            freq=count;
        }

        for(int num:freq){
            ans = (ans + num) % mod;
        }
        return ans;
    }
}
