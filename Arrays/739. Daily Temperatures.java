//*****************************************************(dequee)***************************************************
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        
        return ans;
    }
}


//***********************************************************(using stack)***************************************************
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        int[] ans=new int[n];
        ans[n-1]=0;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]) st.pop();
            if(!st.isEmpty()){
                ans[i]=st.peek()-i;
            }
            else ans[i]=0;
            st.push(i);
        }
        return ans;
    }
}
//************************************************************(Brute Force )***********************************************************
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    temperatures[i]=j-i;
                    flag=true;
                    break;
                }
            }
            if(!flag) temperatures[i]=0;
        }
        return temperatures;
    }
}
