class Solution {
    public int integerReplacement(int n) {
        return helper((long)n);
    }

    private int helper(long n) {
        if(n == 1) return 0;

        if(n % 2 == 0) {
            return 1 + helper(n / 2);
        } else {
            return 1 + Math.min(helper(n - 1), helper(n + 1));
        }
    }
}


//*****************************************(optimized bit manipulation way)************************************class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int steps = 0;
        while(num != 1){
            if((num & 1) == 0){
                num = num >> 1;
            }
            else {
                if(num == 3 || ((num >> 1) & 1) == 0) num--;
                else num++;
            }
            steps++ ;
        }
        return steps;
    }
}
