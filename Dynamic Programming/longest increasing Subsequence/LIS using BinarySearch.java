// binary search from collections give us [-(insertion point) -1 ]
//eg 2,3,5,7 suppsoe we search 6 in our array binary seach return -(3)-1 = -4 if not found the element which we can use to find out the inserting index
//int index = -(- insertion point-1); this will give us the 4 index;
//******************************************************************
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        arr.add(nums[0]);

        int length=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > arr.get(arr.size()-1)){
                arr.add(nums[i]);
                length++;
            }
            else{
                int index=Collections.binarySearch(arr , nums[i]);
                if(index < 0){
                    index = -(index+1);
                }
                arr.set(index , nums[i]);
            }
        }
        return length;
    }
}
