//time complexity:O(n)
//space complexity:O(1)
//******************************************************************************************************************************
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        long long pre =1;
        long long suf =1;
        long long ans = INT_MIN;
        for(int i = 0;i<n;i++){
            if(pre == 0){pre=1;}
            if(suf == 0){suf=1;}
            pre *= nums[i];
            suf *= nums[n-i-1];
            ans = max(ans,max(pre,suf));
        }
        return ans;
    }
};


//*************************************************************(java)***********************************************************
class Solution {
    public int maxProduct(int[] nums) {
        int leftProduct = 1; int rightProduct = 1; int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(leftProduct == 0){
                leftProduct =1;
            }
            if(rightProduct == 0){
                rightProduct =1;
            }
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[nums.length-1-i];
            ans = Math.max(ans,Math.max(leftProduct,rightProduct));
            
        }
        return ans;
    }
}
