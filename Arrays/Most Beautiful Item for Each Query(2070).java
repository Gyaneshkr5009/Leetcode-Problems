class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=queries.length , m = items.length;
        int[] ans=new int[n];
        //sort all items on the basis of their prices;
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        //precompute max beauty for all index;
        int[] maxBeauty=new int[m];
        maxBeauty[0]=items[0][1];
        for(int i=1; i<m ; i++){
            maxBeauty[i]=Math.max(maxBeauty[i-1] , items[i][1]);
        }

        //Pair queries with their original indices and sort by price
        int[][] sortedQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        //sorting all queries bases of number;
        Arrays.sort(sortedQueries , (a,b) -> Integer.compare(a[0] , b[0]));

        int j=0;
        for(int i=0;i<n;i++){
            int price = sortedQueries[i][0];
            int index = sortedQueries[i][1];

            int left=0 , right=m-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(items[mid][0] <= price){
                    j=mid+1; 
                    left=mid+1;
                }
                else right=mid-1;
            }

            ans[index]= j>0 ? maxBeauty[j-1] : 0;
        }

        return ans;
    }
}
