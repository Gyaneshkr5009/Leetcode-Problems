class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] keys=new boolean[rooms.size()];
        keys[0]=true;
        Stack<Integer> st=new Stack<>();
        st.push(0);
        
        //moving forward;
        while(!st.isEmpty()){
            int node= st.pop();
            for(int num:rooms.get(node)){
                if(!keys[num]){
                    keys[num]=true;
                    st.push(num);
                }
            }
        }

        for(boolean i:keys){
            if(!i) return false;
        }
        return true;
    }
}
