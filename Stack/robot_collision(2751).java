Time Complexity: O(nlog⁡n)
Space Complexity: O(n)

**************************************************************************************************************************************************
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n =positions.length;
        Integer[] indexes=new Integer[n];
        for(int i=0 ; i < n ; i++){
            indexes[i]=i;
        }
        Arrays.sort(indexes , (i,j) -> Integer.compare(positions[i] , positions[j]));
        for(int currentIndex:indexes){
            if(directions.charAt(currentIndex)=='R'){
                st.push(currentIndex);
            }
            else{
                while(!st.isEmpty() && healths[currentIndex]>0){
                    int topIndex=st.pop();
                    if(healths[topIndex]>healths[currentIndex]){
                        healths[topIndex]--;
                        healths[currentIndex]=0;
                        st.push(topIndex);
                    }
                    else if(healths[topIndex]<healths[currentIndex]){
                        healths[currentIndex]--;
                        healths[topIndex]=0;
                    }
                    else{
                        healths[currentIndex]=0;
                        healths[topIndex]=0;
                    }
                }
            }
        }
        for(int i=0; i < n ;i++){
            if(healths[i] >0){
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}
