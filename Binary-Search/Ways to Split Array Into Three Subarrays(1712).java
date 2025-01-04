class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        long res = 0;
        // finding prefix sum
        for(int i = 1; i < n; i++) nums[i] += nums[i - 1];
        for(int i = 0; i < n - 2; i++){
            // j to k will be the range for which we get good split
            // 0 - i, first.... i - j/k, second..... j/k - n - 1, thrid
            int j = i + 1;
            int right = n - 2;
            // this binary search will satisfy the condition for first and second splits
            while(j <= right){
                int mid = (j + right)/2;
                if(nums[mid] - nums[i] < nums[i]) j = mid + 1;
                else right = mid - 1; 
            }
            int k = j;
            right = n - 2;
            // this BS will satisfy the condition for second and thrid splits
            while(k <= right){
                int mid = (k + right)/2;
                if(nums[mid] - nums[i] <= nums[n - 1] - nums[mid]) k = mid + 1;
                else right = mid - 1; 
            }
            // now we can simply add the range k - j into our result
            res = (res + k - j) % 1000000007;
        }
        return (int)res;
    }
}
