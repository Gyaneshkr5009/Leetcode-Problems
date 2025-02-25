class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int mod=1000000007;
        int[] prefix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        int count=0;
        int odd=0 , even=1;
        for(int i=0;i<n;i++){
            if(prefix[i]%2==0){
                count=(count+odd)%mod;
                even++;
            }
            if(prefix[i]%2==1){
                count=(count+even)%mod;
                odd++;
            }
        }
        return count;
    }
}
