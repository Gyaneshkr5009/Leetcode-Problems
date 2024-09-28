class Solution {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int digitSum = sumOfDigits(nums[i]);
            minVal = Math.min(minVal, digitSum);
        }
        
        return minVal;
    }
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; 
            num /= 10;        
        }
        return sum;
    }
}
