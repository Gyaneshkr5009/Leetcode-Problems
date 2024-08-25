//time complexity:O(queries*intLength)
//space complexity:O(queries)
//***************************************************************************************************************************
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans=new long[queries.length];
        int half=(intLength+1)/2;
        boolean isEven=(intLength%2==0) ? true :false;
        long start=(long)Math.pow(10,half-1);
        long end=(long)Math.pow(10,half)-1;

        for(int i=0; i< queries.length ;i++){
            if(queries[i] <= end-start+1) ans[i]=pallindrome(queries[i]+start-1 , isEven);
            else ans[i]=-1;
        }
        return ans;
    }

    private long pallindrome(long num , boolean isEven){
        long res=num;
        if(!isEven){
            num/=10;
        }
        while(num>0){
            long digit=num%10;
            res=res*10+digit;
            num/=10;
        }
        return res;
    }
}
