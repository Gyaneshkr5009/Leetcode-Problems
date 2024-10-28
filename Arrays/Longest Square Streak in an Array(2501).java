//time Complexity:O(nlogn);
//space Complexity:O(n);
//***********************************************************************(HashMap)****************************************************
class Solution {
    public int longestSquareStreak(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        Map<Integer , Integer> mpp=new HashMap<>();
        Arrays.sort(nums);
        int maxStreak=0;
        for(int num: nums){
            int root=(int)Math.sqrt(num);
            if(root*root==num && mpp.containsKey(root)){
                mpp.put(num , mpp.getOrDefault(root,0)+1);
            }
            else{
                mpp.put(num ,1);
            }
            maxStreak=Math.max(maxStreak , mpp.get(num));
        }
        return maxStreak<2 ? -1 : maxStreak;
    }
}

//*********************************************************************(brute Force)*******************************************************
class Solution {
    public int longestSquareStreak(int[] nums) {
        if(nums==null || nums.length==0) return -1;

        Set<Integer> hs=new HashSet<>(); // this will store all nums element;
        for(int num : nums) hs.add(num);
        
        int maxStreak=-1;
        for(int num:nums){
            int count =1;
            int curr=num;

            for(int j=0;j<nums.length ;j++){
                if(hs.contains(curr*curr)){
                    count++;
                    curr=curr*curr;
                }
            }
            maxStreak=Math.max(maxStreak , count);
        }
        if(maxStreak==1) return -1;
        return maxStreak;
    }
}
//****************************************************************(optimal approach)*********************************************************
class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int maxStreak = 0;
        for (int num : nums) {
            int streak = 0;
            long curr = num;
            while (st.contains((int) curr)) {
                streak++;
                if (curr * curr > 1e5) {
                    break;
                }
                curr = curr * curr; // square
            }
            maxStreak = Math.max(maxStreak, streak);
        }
        return maxStreak < 2 ? -1 : maxStreak;
    }
}
