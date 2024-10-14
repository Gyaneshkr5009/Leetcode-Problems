/*
  Approach:

    Max Heap Construction: A priority queue is used (with Collections.reverseOrder() to act as a max heap) to always get the largest element efficiently.
    Score Calculation: In each of the k operations:
        Extract the largest element (num).
        Add it to the score.
        Replace num by its ceiling of num/3 and reinsert it into the heap.
    Return Total Score: After k operations, the total score is returned.

Time Complexity:

    Building the heap takes O(n log n).
    Each operation (poll + offer) is O(log n), so the overall complexity for k operations is O(k log n).

Space Complexity:

    O(n) due to the priority queue storing up to n elements.
*/
//***********************************************************(PriorityQueue)*****************************************************************************
class Solution {
    public long maxKelements(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        long score=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int a:nums) pq.offer(a);

        while(k>0){
            int num=pq.poll();
            score+=num;
            num=(int)Math.ceil(num/3.0);
            pq.offer(num);
            k--;
        }
        return score;
    }
}

//*************************************************************(optimized approach)********************************************************************
class Solution {
    public long maxKelements(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0; //exceptional case 
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        //creating predefined max-heap using [Collections.reverseOrder()] as [(a,b) -> b-a] is slower due to comparison at every time;
        for(int a:nums) pq.offer(a);  //inserting all value in max-heap

        long score=0;

        while(k-->0){
            int num=pq.poll();
            score+=num;
            pq.offer((num+2)/3); 
            // [Math.ceil()] make our program slower so we use numeric method to make it faster;
            //just try again future mean taking a rough notebook and go through (java Documentation);
        }
        return score;
    }
}
