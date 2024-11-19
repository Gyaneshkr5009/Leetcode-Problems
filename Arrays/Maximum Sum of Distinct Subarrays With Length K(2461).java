/*
    Sliding Window Core Idea:
    Use two pointers (i and j) to define a dynamic window, expanding the window (j++) to include new elements and shrinking it (i++) to maintain distinct elements or the desired window size.
    
    Handling Duplicates:
    Use a HashSet to track elements within the window. If a duplicate is encountered, shrink the window by removing elements from the left until the duplicate is resolved.
    
    Real-Time Sum Tracking:
    Maintain a sum variable to store the current subarray sum in the window. Adjust sum incrementally as elements are added or removed for efficient calculations.
    
    Result Maximization:
    Update the result with the maximum value of sum when the window size equals k.
    
    Time Complexity:
    O(n) – Each element is added and removed from the window at most once.
    
    Space Complexity:
    O(k) – The HashSet can hold up to k elements at any given time.
*/

//*********************************************************************(sliding window approach)****************************************************************

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0 , j=0;
        int n=nums.length;

        Set<Integer> set=new HashSet<>();
        //to check whether the element is repeated or not;

        long result=0 , sum=0;

        //sliding window approach;
        while(j<n){
            if(!set.contains(nums[j])){
                sum+=nums[j];
                set.add(nums[j]);
                //if the size of the window becomes equal to k , we got one substring;
                if(j-i+1==k){
                    //compairing and pick max from them;
                    result=Math.max(result , sum);
                    set.remove(nums[i]);
                    sum-=nums[i++];
                }
                j++;
            }
            else{
                while(set.contains(nums[j])){
                    sum-=nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            }
        }
        return result;
    }
}
//******************************************************(optimized)****************************************************************************************
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        long result = 0;
        long currWindowSum = 0;
        HashSet<Integer> set = new HashSet<>();

        while (j < nums.length) {
            // Adjust the window if nums[j] is already in the set
            while (set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            currWindowSum += nums[j];
            set.add(nums[j]);

            // Check if the window size is equal to k
            if (j - i + 1 == k) {
                result = Math.max(result, currWindowSum);

                // Shrink the window from the left
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return result;
    }
}
