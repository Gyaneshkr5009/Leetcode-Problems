//*********************************************************(optimized approach)********************************

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp=new ArrayList<>();

        helper(k , n  , 1 , 0, temp);
        return ans;
    }
    private void helper(int k , int n , int start , int sum , List<Integer> temp){
        if(temp.size()==k){
            if(sum==n) ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=start;i<=9;i++){
            if(sum+i > n) break;
            temp.add(i);
            helper(k ,n , i+1 , sum+i , temp);
            temp.remove(temp.size() - 1);
        }
    }
    private List<List<Integer>> ans=new ArrayList<>();
}


//*************************************************************************************************************
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] number=new boolean[10]; //0 to 9
        List<Integer> temp=new ArrayList<>();

        for(int i=1 ;i<=9;i++){
            number[i]=true;
            temp.add(i);
            helper(k , n  , 1 , i , number , temp);
            number[i]=false;
            temp.remove(temp.size()-1);
        }
        return ans;
    }
    private void helper(int k , int n , int length , int sum , boolean[] visited , List<Integer> temp){
        if((length==k && sum!=n) || sum>n) return ;
        if(length==k && sum==n){
            ans.add(new ArrayList<>(temp));
        }
        for(int i=1;i<=9;i++){
            if(!visited[i] && i>temp.get(temp.size()-1)){
                visited[i]=true;
                temp.add(i);
                helper(k , n , length+1 , sum+i , visited , temp);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    private List<List<Integer>> ans=new ArrayList<>();
}
