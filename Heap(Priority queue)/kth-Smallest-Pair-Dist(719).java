//1st approach using sliding window approach

class Solution {
    private int slidingWindowCount(int[] nums, int D) {
        int count = 0;
        int n = nums.length;
        int i = 0;
        int j = 1;

        while (j < n) {
            while (nums[j] - nums[i] > D) {
                i++;
            }
            count += j - i;
            j++;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = slidingWindowCount(nums, mid);

            if (count < k) {
                l = mid + 1;
            } else {
                result = mid;  // Store the mid as a potential result
                r = mid - 1;
            }
        }
        return result;
    }
}

***************************************************************************************************************************************
  //2nd approach suing max PriorityQueue

  public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;
        //min PriorityQueue declare
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ;i<n-1 ;i++){
            for(int j=i+1;j<n;j++){
                int diff=Math.abs(nums[i]-nums[j]);
                if(pq.size()<k){
                    pq.add(diff);
                }
                else{
                    if(pq.peek()!=null && pq.peek()>diff){
                        pq.poll();
                        pq.add(diff);
                    }
                }
            }
        }
        if(pq.isEmpty()) return -1;
        return pq.poll();
    }
