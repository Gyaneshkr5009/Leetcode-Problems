//time complexity:O(log(sum-max)*n);
//space complexity:O(1)

//question is find min capacity of boat to transfer all weights in d days;
//so capacity={10 to 55} => {max , sum};
//*************************************************************************************************************************************
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE , sum=0;
        for(int n:weights){
            sum+=n;
            max=Math.max(max, n);
        }
        if(days==1) return sum;
        if(days==weights.length) return max;
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(days(weights,mid)<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private int days(int[] weights , int cap){
        int day=1 , load=0;
        for(int n:weights){
            if(n+load>cap){
                day++;
                load=n;
            }
            else{
                load+=n;
            }
        }
        return day;
    }
}
