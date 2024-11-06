/*
    >> Backtracking Approach: Use backtracking to generate all permutations by exploring each element recursively and keeping track of visited elements.
    >> Tracking Visited Elements: Use a visited array to mark which elements have been included in the current permutation to avoid duplicates.
    >> Base Case: Once the current permutation has the same length as the input array, add it to the result list.
    >> Backtrack: After exploring a branch, remove the last element added and mark it as unvisited to try the next possibility.
    >> Recursion: The recursion explores each element, adding it to the permutation and then backtracking.
*/
//time comlexity:O(n!)
//space complexity:O(n)
//*******************************************************************************************************************************************
class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0) return ans;
        
        List<Integer> ds=new ArrayList<>(); // this will store the element;
        int[] visited=new int[nums.length]; // to keep track of each visited and not visited element;

        //we recursion through each num;
        for(int i=0;i<n ;i++){
            helper(i , nums , ds , visited);
        }
        return ans;
    }
    private void helper(int idx , int[] nums , List<Integer> ds , int[] visited){
        visited[idx]=1;
        ds.add(nums[idx]);
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size()-1);
            visited[idx]=0;
            return;
        }
        //those who havent visited starting a branch with each in recursion;
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                helper(i , nums , ds , visited);
            }
        }
        ds.remove(ds.size()-1); //undo the last added element, so as to procedd with new one;
        visited[idx]=0; // backtracking by making it unvisited again;
    }
}
