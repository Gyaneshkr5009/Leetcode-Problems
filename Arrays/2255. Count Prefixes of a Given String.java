class Solution {
    public int countPrefixes(String[] words, String s) {
        if(words==null || words.length==0) return 0;
        int count=0;
        for(String st:words){
            if(s.startsWith(st)) count++;
        }
        return count;
    }
}
