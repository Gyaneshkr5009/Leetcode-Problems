class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb=new StringBuilder();
        List<String> result=new ArrayList<>();
        findSequence(n, sb , result);
        if(result.size()<k) return "";
        return result.get(k-1);
    }
    private void findSequence(int n , StringBuilder curr, List<String> result){
        int size=curr.length();
        if(size==n){
            result.add(curr.toString());
            return;
        }

        for(char ch='a' ; ch <= 'c' ; ch++){
            if(size>0 && curr.charAt(size-1)==ch) continue;
            curr.append(ch);
            findSequence(n , curr , result);
            curr.deleteCharAt(curr.length()-1); //backtrack;
        }
    }
}
