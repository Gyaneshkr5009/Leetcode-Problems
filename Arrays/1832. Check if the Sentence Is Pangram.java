class Solution {
    public boolean checkIfPangram(String str) {
        if(str==null || str.length()==0) return false;
        for(char ch='a' ; ch<='z' ;ch++){
            if(str.indexOf(ch)<0) return false;
        }
        return true;
    }
}
