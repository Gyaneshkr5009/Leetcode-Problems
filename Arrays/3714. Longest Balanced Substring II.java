//*************************************(normal Approach[prefix freq cal])*****************************************************
class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int length=0;

        int[][]freq = new int[n][26];
        //prefix freq fill

        for(int i=0;i<n;i++){
            //step 1 : copy the previous node then update the current element freq;
            if(i>0){
                for(int c=0  ; c<26 ; c++){
                    freq[i][c] = freq[i-1][c];
                }
            }
            freq[i][s.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int[] curr = new int[26];
                int max=0;

                for(int c=0;c<26;c++){
                    curr[c] = freq[j][c] - (i>0 ? freq[i-1][c] : 0);
                    max=Math.max(max , curr[c]);
                }

                boolean ok = true;
                for(int c = 0; c < 26; c++){
                    if(curr[c] != 0 && curr[c] != max){
                        ok = false;
                        break;
                    }
                }

                if(ok) length = Math.max(length, j - i + 1);
            }
        }
        return length;
    }
}
//*****************************************************************(more optimal)************************************
class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int ans=0;

        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            int unique=0;
            int maxFreq=0;
            for(int j=i;j<n;j++){
                //if this is unique number;
                if(freq[s.charAt(j) - 'a'] == 0){
                    unique++;
                }
                maxFreq=Math.max(maxFreq , ++freq[s.charAt(j)-'a']);
                int length = j-i+1;
                if(length == unique*maxFreq){
                    ans= Math.max(length , ans);
                }
            }
        }
        return ans;
    }
}
//***************************************************************************(optimised)******************************
