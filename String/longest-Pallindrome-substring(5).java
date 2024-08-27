//time complexity:O(n^2);
//space complexity:O(1);

//*************************************************************************************************************************************
class Solution {
    public String longestPalindrome(String s) {
        int maxLength=1;
        int n =s.length();
        int strt=0;
        for(int i=1;i<n ;i++){
            //for even length substring;
            int low=i-1;
            int high=i;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high-low+1>maxLength){
                    strt=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }

            //for odd length substring
            low=i-1;
            high=i+1;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if(high-low+1>maxLength){
                    strt=low;
                    maxLength=high-low+1;
                }
                low--;
                high++;
            }
        }
        return s.substring(strt , strt+maxLength);
    }
}
