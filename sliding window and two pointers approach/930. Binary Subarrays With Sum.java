class Solution {

    public int numSubarraysWithSum(int[] arr, int k) {

        Map<Integer,Integer> map=new HashMap<>();

        int count=0;

        int sum=0;

        int l=0;

        while(l<arr.length){

            sum=sum+arr[l];

            if(sum==k){

                count++;

            }

            if(map.containsKey(sum-k)){

                count=count+map.get(sum-k);

            }

            map.put(sum,map.getOrDefault(sum,0)+1);

            l++;

        }

        return count;

    }

}
