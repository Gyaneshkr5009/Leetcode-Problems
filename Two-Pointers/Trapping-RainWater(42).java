time complexity: O(n);
space complexity: O(1)

************************************************************************
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0 ,right=n-1;
        int leftMax=0 ,rightMax=0;
        int waterStored=0;
        // here we check if leftMax is bigger update it same for rightMax;
        //then we have got arr[left] is smaller to right or vice versa after passing if else loop;
        //then we just subtract the maxone -arr[left  or right] to get how much water we can fill; 
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax) leftMax=height[left];
                else waterStored+=leftMax-height[left];
                left++;
            }
            else{
                if(height[right]>=rightMax) rightMax=height[right];
                else waterStored+=rightMax-height[right];
                right--;
            }

        }
        return waterStored;
    }
}
