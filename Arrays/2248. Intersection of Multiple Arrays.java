class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length , m=nums[0].length;
        HashMap<Integer , Integer> mpp=new HashMap<>(); // creatin a hasmap that stores keys and their count;
        for(int[] a:nums){
            for(int b:a){
                mpp.put(b, mpp.getOrDefault(b,0)+1);
            }
        }
        //after storing all the number get those values that have count == n;
        for(int key:mpp.keySet()){
            if(mpp.get(key)==n) ans.add(key);
        }
        //finnaly sort them to get the ans;
        Collections.sort(ans);
        return ans;
    }
}
