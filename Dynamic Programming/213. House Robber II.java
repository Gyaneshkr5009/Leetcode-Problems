class Solution {
    public int rob(int[] nums) {
        ArrayList<Integer> temp =new ArrayList<>() , temp2=new ArrayList<>();
        int n=nums.length;
        if(n==1) return nums[0];
        for(int i=0;i<n ;i++){
            if(i!=0) temp.add(nums[i]);
            if(i!=n-1) temp2.add(nums[i]);
        }
        return Math.max(solve(temp) , solve(temp2));
    }
    private int solve(ArrayList<Integer> nums){
        int n=nums.size();
		int prev=nums.get(0) , prev2=0;
		for(int i=1;i<n;i++){
			int pick=nums.get(i);
			if(i>1) pick+=prev2;
			int notPick=prev;
			int curr=Math.max(pick , notPick);
            prev2=prev;
            prev=curr;
		}
		return prev;
    }
}
