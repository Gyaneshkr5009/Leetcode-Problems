class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        Integer[] orderedElements = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            orderedElements[i] = i;
        }
        Arrays.sort(orderedElements, (a,b) -> nums[a] == nums[b] ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]));
        for (int i = 0; i < nums.length; i++) {
            if (nums[orderedElements[i]] != 0) {
                score += nums[orderedElements[i]];
                nums[orderedElements[i]] = 0;
                if (orderedElements[i] > 0) {
                    nums[orderedElements[i] - 1] = 0;
                }
                if (orderedElements[i] < nums.length - 1) {
                    nums[orderedElements[i] + 1] = 0;
                }
            }
        }
        return score;
    }
}

//*********************************************************************************************************************************************************************
//time complexity:O(n);
//space complexity:O(n);
//*****************************************************************(Normal approach)*********************************************
class Solution {
    public long findScore(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length;

        long score=0;
        //min heap if number are equal then sort by index;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.value!=b.value?a.value-b.value : a.idx-b.idx);
        for(int i=0 ;i<n ;i++){
            pq.offer(new Pair(nums[i] , i));
        }
        // Use visited array to track already processed indices
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currVal = pair.value;
            int currIdx = pair.idx;

            if (visited[currIdx]) continue;
            score += currVal;
            visited[currIdx] = true;
            if (currIdx - 1 >= 0) visited[currIdx - 1] = true;
            if (currIdx + 1 < n) visited[currIdx + 1] = true;
        }
        return score;
    }

}
class Pair{
    int value;
    int idx;
    Pair(int value , int idx){
        this.value=value;
        this.idx=idx;
    }
}
