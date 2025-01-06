class Solution {
    public int mostWordsFound(String[] sentences) {
        int length=0;
        for(String str:sentences){
            int currLen=str.split(" ").length;
            if(length < currLen) length=currLen;
        }
        return length;
    }
}
