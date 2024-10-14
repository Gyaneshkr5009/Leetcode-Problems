/*
    Max-Heap: Use a max-heap to efficiently retrieve the largest pile of stones.
    Operation: For each of the k operations, remove the largest pile, replace it with half of its value (using (n + 1) / 2 to account for rounding up), and add it back to the heap.
    Calculate Score: After performing k operations, sum the remaining piles in the heap to get the final score.

    Time Complexity: O(k log n)
    Space Complexity: O(n)
*/
//********************************************************************(max-heap)***************************************************************
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int score=0;
        for(int a:piles ) pq.offer(a);

        while(k-->0){
            int n=pq.poll();
            pq.offer((n+1)/2);
        }

        while(!pq.isEmpty()){
            score+=pq.poll();
        }
        return score;
    }
}

//**********************************************************************(other approach)****************************************************************
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int score=0;
        for(int a:piles ) pq.offer(a);

        while(k-->0){
            int curr=pq.poll();
            int remove=curr/2;
            pq.offer(curr-remove);
        }
        //replacing with while method as that method performs two operation [Adding and Removing] which makes it slower;
        for(int num:pq){
            score+=num;
        }
        return score;
    }
}
