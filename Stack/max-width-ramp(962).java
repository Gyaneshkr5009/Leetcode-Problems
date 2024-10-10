/*
    Descending Stack: Build a stack that holds indices of elements in a strictly decreasing order from left to right.
    Max Ramp Search: Traverse from the right and try to find the largest valid ramp by comparing elements with those in the stack.
    Update Result: Whenever a valid ramp is found (i.e., nums[i] >= nums[stack[top]]), update the maximum ramp width.
    Return Maximum Ramp: Continue until the maximum width ramp is identified.

    Time Complexity: O(N)
    Space Complexity: O(N)
*/

//*******************************************************************(optimized approach)*****************************************************************************************
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length, top = 0, ans = 0;
        int[] stack = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[stack[top]]) {
                stack[++top] = i;
            }
        }
        for (int i = n - 1; i > ans; i--) {
            while (top >= 0 && nums[i] >= nums[stack[top]]) {
                top--;
            }
            ans = Math.max(ans, i - stack[top + 1]);
        }
        return ans;
    }
}

//********************************************************************(average approach)*****************************************************************************
//time complexity:O(n);
//space complexity:O(n);
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0) return 0;
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(st.isEmpty() || nums[st.peek()]>nums[i]) st.push(i);
        }

        int width=0;
        for (int j = n - 1; j >= 0; j--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[j]) {
                width = Math.max(width, j - st.pop());
            }
        }
        return width;
    }
}

//***********************************************************************(brute force)**************************************************************************
class Solution {
    public int maxWidthRamp(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int width=0;
        int n =nums.length;
        for(int i=n-1 ; i>=0 ;i--){
            int num=nums[i];
            for(int j=0;j<i;j++){
                if(nums[j]<=nums[i]){
                    width=Math.max(width , i-j);
                    break;
                }
            }
        }
        return width;
    }
}
