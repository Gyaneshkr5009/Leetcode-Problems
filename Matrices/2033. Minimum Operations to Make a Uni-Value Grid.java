class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length , m=grid[0].length , idx=0;
        int[] arr=new int[n*m];
    
        for(int[] nums:grid){
            for(int num:nums) arr[idx++]=num;
        }

        Arrays.sort(arr);
        int median = arr[(n*m) / 2];
        int operations = 0;

        for (int num : arr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;
            operations += diff / x;
        }

        return operations;
    }
}
