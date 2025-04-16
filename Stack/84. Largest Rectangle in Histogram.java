class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;

        Stack<Integer> st=new Stack<>();
        int max=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element=heights[st.pop()];
                int nextSmallerElementIndex=i;
                int previousSmallerElementIndex= !st.isEmpty()?st.peek():-1;
                max=Math.max(max , element*(nextSmallerElementIndex - previousSmallerElementIndex -1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element=heights[st.pop()];
            int nse=n;
            int pse=!st.isEmpty()?st.peek():-1;
            max=Math.max(max , element*(nse-pse-1));
        }
        return max;
    }
}
