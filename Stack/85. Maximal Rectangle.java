class Solution {
    //normal rectangle find in histogram logic apply for all array[i] in a matrix[][];
    /*ex=>  array[0]= 1,0,1,0,0;
            array[1]= 2,0,2,1,1;
            array[2]= 3,1,3,2,2;
            array[3]= 4,0,0,3,0;   
        as we move to another index we added the value to previous one if it is >0 other wise total hieght becomes 0;
        our intital histogram array was [0,0,0,0,0];
        as we move to arrays[i] in matrix we  add that value to our histogram matrix and pass ont his matrix to out 
        solve histogram fuctn(histogram);
    */
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length , m=matrix[0].length;
        
        int[] histogram=new int[m];

        int max=0;
        for(char[] arr:matrix){
            for(int i=0;i<m;i++){
                if(arr[i]-'0' == 1) histogram[i]+=(arr[i]-'0');
                else histogram[i]=0;
            }
            //now our new histogram is formed
            max=Math.max(max, solveHistogram(m , histogram));
        }
        return max;
    }
    //this fuctn will return me the largest possible area in curr histogram;
    private int solveHistogram(int n , int[] histogram){
        Stack<Integer> st=new Stack<>();

        int max=0;

        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || histogram[st.peek()] > histogram[i])){
                int element=histogram[st.pop()];
                int nextSmallerIndex=i;
                int prevSmallerIndex= st.isEmpty() ? -1 : st.peek();
                max=Math.max(max, element*(nextSmallerIndex-prevSmallerIndex-1));
            }
            st.push(i);
        }
        return max;
    }
}
