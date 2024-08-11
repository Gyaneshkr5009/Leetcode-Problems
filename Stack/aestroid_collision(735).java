class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i: asteroids){
            while(!st.isEmpty() && st.peek()>0 && i<0){
                int sum=i+st.peek();
                if(sum<0) st.pop();
                else if(sum>0){
                    i=0;
                    break;
                }
                else{
                    st.pop();
                    i=0;
                }
            }
            if(i!=0) st.push(i);
        }
        int[] ans = new int[st.size()];
        for (int j = ans.length - 1; j >= 0; j--) ans[j] = st.pop();
        return ans;
    }
}
