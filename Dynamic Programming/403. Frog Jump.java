/*
    Approach

Purpose: Solve if a frog can cross stones by jumping based on the last jump size.
Key Structures:

Map to store stone values with indices for fast lookup.
Set to track visited (position, last jump) states and avoid redundant work.

Logic Flow:

Use recursion to explore three possible jumps: lastJump−1lastJump−1, lastJumplastJump, and lastJump+1lastJump+1.
Base cases handle invalid positions, revisits, and reaching the last stone.

Optimization: Memoization via visited reduces redundant state exploration, improving efficiency.
Complexity: Exponential in worst-case without memoization; practical performance depends on state pruning.
*/

//time complaxity:O(n2) = space complexity;
//*****************************************************************************************************************************
class Solution {
    public boolean canCross(int[] stones) {
        if(stones==null || stones.length==0) return false;
        int n=stones.length;
        Map<Integer , Integer> mpp=new HashMap<>();
        Set<String> visited =new HashSet<>();

        for(int i=0; i<stones.length;i++){
            mpp.put(stones[i] , i); //stones value with index stored;
        }
        int lastJump=1 , position=1;
        int currIdx=1;
        return helper(stones , lastJump , position , currIdx , mpp ,n , visited);
    }
    private boolean helper(int[] arr , int lastJump , int position , int currIdx ,Map<Integer,Integer> mpp , int n , Set<String> visited){
        if(!mpp.containsKey(position) || currIdx >= n) return false;

        String state=position + "," + lastJump;
        if(visited.contains(state)) return false;
        visited.add(state);

        
        currIdx=mpp.get(position);
        
        if(position == arr[n-1] && currIdx==n-1) return true;

        int backJump=lastJump-1;
        int forwardJump=lastJump+1;

        if(backJump>0){
            if(helper(arr , backJump , position+backJump , currIdx ,mpp ,n , visited)) return true;
        }
        if(helper(arr, lastJump , position+lastJump , currIdx ,mpp ,n , visited)) return true;
        if(helper(arr , forwardJump , position+forwardJump , currIdx ,mpp , n , visited)) return true;
        return false;
    }
}
