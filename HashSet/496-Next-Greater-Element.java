    Time complexity:
    O(n) => for adding all element with their index to HashMap;
    O(nn) => for getting the highest element;
    total => O(nn+n) or O(n*n);

    Space complexity:
    O(n) => ans array use spaces of n ;
    O(n) => HashMap;
    total => O(n+n) => O(n);

//approach is we stores nums2 element in HashMap with their index and then we check nums1 element index in HashMap and move our j pointer until it get the next highest;
***************************************************************************************************************************************************************************************
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int[] ans=new int[n];
        // using hashmap to store nums2 element with index;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int idx=0;
        for(int p:nums2) mpp.put(p, idx++);
        idx=0;
        for(int i =0 ;i<n ;i++){
            int num=nums1[i];
            for(int j=mpp.get(num)+1 ; j<nums2.length ;j++ ){
                if(nums2[j]>num){
                    ans[idx]=nums2[j];
                    break;
                }
            }
            if(ans[idx]==0) ans[idx]=-1;
            idx++;
        }
        return ans;
    }
}

**************************************************************************************************************************
    //optimal approach
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        for(int i=0 ;i < nums2.length ;i++){
            map[nums2[i]]=i;
        }
        for(int i=0 ;i < nums1.length ;i++){
            nums1[i] = find(map[nums1[i]] , nums2);
        }
        return nums1;
    }
    private int find(int idx , int nums2[]){
        int num=nums2[idx];
        for(int i=idx+1 ; i<nums2.length ;i++){
            if(nums2[i] > num) return nums2[i];
        }
        return -1;
    }
}
