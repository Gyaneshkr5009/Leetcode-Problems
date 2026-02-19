class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result = new int[n-k+1]; // this is the range of result array

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //remove element that are beyong the scope of the window, no need to keep it;
            while(!dq.isEmpty() && dq.peekFirst() < i-k+1) dq.removeFirst();

            //now remove the elments that is smaller then the curr element
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();

            //after that add the current element that maybe max for someone;
            dq.addLast(i);
            
            //we can start adding ans if it reaches end of the k size window;
            if(i>=k-1){
                //i-k+1  => this is the starting point of the window;
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
