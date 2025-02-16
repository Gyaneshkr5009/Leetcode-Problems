class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        
        //creating a min heap to store all the numbers in pq ;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long num:nums) pq.offer(num);

        int count=0;
        while(!pq.isEmpty() && pq.peek()<k){
            long smallest=pq.poll();
            long secondSmallest=pq.poll();

            pq.offer(smallest*2 + secondSmallest);
            count++;
        }
        return count;
    }
}
