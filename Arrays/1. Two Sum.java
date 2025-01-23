class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem=target-nums[i];
            if(hs.containsKey(rem)) return new int[]{i , hs.get(rem)};
            else hs.put(nums[i] , i);
        }
        return new int[]{};
    }
}
