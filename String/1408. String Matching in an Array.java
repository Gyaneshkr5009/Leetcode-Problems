class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans=new ArrayList<>();
        int n=words.length;
        if(words==null || n==0) return ans;

        Arrays.sort(words , (a,b)-> Integer.compare(a.length() , b.length()));
        for(int i=0;i<n-1;i++){
            String str=words[i];
            for(int j=i+1;j<n;j++){
                if(words[j].indexOf(str)!=-1){
                    ans.add(str);
                    break;
                }
            }
        }
        return ans;
    }
}
