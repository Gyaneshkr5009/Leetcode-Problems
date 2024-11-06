//time complexity:o(n*n)
//space complexity:O(1)
//*********************************************************(Brute Force)*************************************************************************
class Solution {
    public boolean canSortArray(int[] nums) {
        if(nums==null || nums.length==0) return true;
        int n =nums.length;
        //using bubble sort
        for(int i=0 ; i<n ;i++){
            int flag=0;
            for(int j=0 ; j<n-1-i ; j++){
                //agar number bda ho or bits same ho toh swap ker do;
                if(nums[j] > nums[j+1] && setBits(nums[j]) == setBits(nums[j+1])){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0) break;
        }
        
        for(int i=0;i<n-1 ; i++){
            if(nums[i]>nums[i+1]) return false;
        }
        return true;
    }

    //here we converting the number into bits and counting all ones
    private int setBits(int num){
        int cnt=0;
        while(num>0){
            cnt+=num%2;
            num=num/2;
        }
        return cnt;
    }
}
//*************************************************************(optimized approach)****************************************************
//time complexity:O(n*n);
//space complexity:O(1);
class Solution {
    public boolean canSortArray(int[] nums) {
        if(nums==null || nums.length==0) return true;
        int n =nums.length;
        //using bubble sort
        for(int i=0 ; i<n ;i++){
            int flag=0;
            for(int j=0 ; j<n-1-i ; j++){
                //agar number bda ho or bits same ho toh swap ker do;
                if(nums[j] > nums[j+1]){
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                        flag=1;
                    }
                    else return false;
                }
            }
            if(flag==0) break;
        }
        
        for(int i=0;i<n-1 ; i++){
            if(nums[i]>nums[i+1]) return false;
        }
        return true;
    }
}
