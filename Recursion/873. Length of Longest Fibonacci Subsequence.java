//*****************************************(brute force)************************************************
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        Set<Integer> st=new HashSet<>();
        for(int num:arr) st.add(num);
        
        int maxLength=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1 ;j<n ;j++){
                maxLength=Math.max(maxLength , helper(arr , st, arr[i] , arr[j] , 2));
            }
        }
        return maxLength;
    }
    private int helper(int[] arr , Set<Integer> st, int firstNum , int secNum , int length){
        int nextNum=firstNum+secNum;
        if(!st.contains(nextNum)) return length;
        return helper(arr , st , secNum , nextNum , length+1);
    }
}

//**********************************************************(memoization)*********************************
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a ,2);
        Map<Integer ,Integer> mpp=new HashMap<>();
        for(int num=0; num<arr.length ;num++){
            mpp.put(arr[num] , num); // storing num with idx;
        }
        
        int maxLength=0;
        for(int j=1;j<n-1;j++){
            for(int k=j+1 ;k<n ;k++){
                int thirdNum=arr[k]-arr[j];
                if(mpp.containsKey(thirdNum) && mpp.get(thirdNum)<j){
                    int i=mpp.get(thirdNum);
                    dp[j][k]=dp[i][j]+1;
                }
                maxLength=Math.max(maxLength , dp[j][k]);
            }
        }
        return maxLength>=3 ? maxLength :0;
    }
}
