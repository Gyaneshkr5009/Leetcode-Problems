 Time Complexity: O(n) for the for loop and O(n) for the number of element at max can be poppedout from stack  => O(2n)
  Space Complexity : O(2n);

//approach to solve using stack just consider all stack elements as pole that only get bigger when we move from 0 -> N in an array;
// so when we incounter something greater in stack then the current iterative element just push that to that place and store iterative element to the top of stack; 
********************************************************************************************

  public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();
            if(st.isEmpty()) ans[i]=-1;
            else ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
}
