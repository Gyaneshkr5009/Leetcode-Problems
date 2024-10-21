//********************************************************************************(Dijkstra's Algorithm)*******************************************************
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        if (arr == null || arr.length == 0) return -1;
        if (start == end) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.step - y.step);
        pq.offer(new Pair(start, 0));  // Start with the given node having 0 multiplications.

        int[] steps = new int[100000];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[start] = 0;

        int mod = 100000;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int num = pair.num;
            int step = pair.step;
            
            // If we reached the target node, return the steps.
            if (num == end) return step;

            // Explore all possible multiplications.
            for (int a : arr) {
                int newNum = (a * num) % mod;

                // If the new step count is smaller, update and push to the priority queue.
                if (step + 1 < steps[newNum]) {
                    steps[newNum] = step + 1;
                    pq.offer(new Pair(newNum, steps[newNum]));
                }
            }
        }

        // If we didn't reach the end node, return -1.
        return -1;
    }
}

class Pair{
    int num;
    int step;
    Pair(int num , int step){
        this.num=num;
        this.step=step;
    }
}
