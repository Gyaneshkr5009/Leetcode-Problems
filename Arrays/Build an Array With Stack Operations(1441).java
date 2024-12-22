class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operation=new ArrayList<>();
        int idx=0;
        for(int i=1;i<=n;i++){
            operation.add("Push");
            if(i==target[idx]){
                idx++;
                if(idx==target.length) break;
            }
            else{
                operation.add("Pop");
            }
        }
        return operation;
    }
}
