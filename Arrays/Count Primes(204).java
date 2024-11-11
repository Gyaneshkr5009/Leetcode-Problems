//time complexity:O(n) + O(n(log(log n)) + O(n);
//space complexity:O(n);
//*************************************************************(using Sieve of Eratosthenes Algorithm)************************************************
class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1 || n==2) return 0;
        int[] prime = new int[n+1];
        Arrays.fill(prime , 1);
        markPrime(n , prime);

        int cnt=0;
        for(int i=2; i<n ;i++){
            if(prime[i]==1) cnt++;
        }
        return cnt;
    }
    private void markPrime(int n  , int[] prime){
        for(int i=2 ; i<=Math.sqrt(n) ; i++){
            if(prime[i]==1){
                //marking all multiples of prime as 0 that denotes not a prime number;
                for(int j=i*i ; j<=n ; j+=i){
                    prime[j]=0;
                }
            }
        }
    }
}
