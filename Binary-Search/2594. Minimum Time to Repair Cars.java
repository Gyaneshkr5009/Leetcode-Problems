class Solution {
    private boolean canRepair(int[] ranks ,long cars, long targetTime){
        long repair=0;
        for(int rank:ranks){
            repair+=(long)Math.sqrt((double)targetTime/rank);
            if(repair>=cars) return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long maxRank=Long.MIN_VALUE;
        for(int a:ranks){
            maxRank=Math.max(a , maxRank);
        }
        long ans=Long.MAX_VALUE;
        // i got the maxRank guy so the minumum to solve will be 1 hypothetically and max time to repair all is the maxRank*cars*cars;
        long left=1 , right=maxRank*(long)cars*cars;
        while(left<=right){ 
            long mid=left+(right-left)/2;
            if(canRepair(ranks , cars , mid)){
                //if i get true i will look for the left;
                ans=Math.min(ans, mid);
                right=mid-1;
            }
            //else minimum time to repair all will be on the right;
            else left=mid+1;
        }
        return ans;
    }
}
