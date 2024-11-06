/*
    >> Backtracking with Unique Permutations: Use backtracking to generate all unique permutations by exploring each element, while ensuring duplicates are not processed.
    >> Sorting: Sort the input array to group duplicates together, allowing easy skipping of identical elements during recursion.
    >> Tracking Visited Elements: Use a visited array to keep track of which elements are included in the current permutation.
    >> Skipping Duplicates: If the current element is the same as the previous one and the previous one was not used, skip the current element to avoid duplicate permutations.
    >> Backtracking: After exploring a branch, remove the last element added and mark it as unvisited to continue with other possibilities.
*/
//time complexity:O(n!);
//space complexity:O(n);
//*************************************************************************************************************************************************
class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        if(nums==null || nums.length==0) return ans;

        int[] visited=new int[n]; // to keep track of each element if they are visited or not;
        List<Integer> ds=new ArrayList<>();

        Arrays.sort(nums); // so that all duplicates numbers are grouped to each other;
        helper (nums , ds , visited);
        return ans;
    }
    private void helper(int[] nums , List<Integer> ds , int[] visited){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0 ;i < nums.length ; i++){
            if(visited[i]==1) continue;
            // means we already does with recursion with the same element;
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]==0) continue; 

            visited[i]=1;
            ds.add(nums[i]);
            helper(nums, ds, visited);
            //backtrack
            visited[i]=0;
            ds.remove(ds.size()-1); // removing last element;
        }
    }
}
