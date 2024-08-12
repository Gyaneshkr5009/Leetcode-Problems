class KthLargest {
    public PriorityQueue<Integer> pq=new PriorityQueue<>();
    public int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums) add(n);
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k ) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
