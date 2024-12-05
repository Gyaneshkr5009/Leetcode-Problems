class Solution {
    public boolean canChange(String strt, String target) {
        if(strt==null || strt.length()==0 || target==null || target.length()==0) return false;
        int strtL=0 , strtR=0 , targetL=0 , targetR=0;

        //checking their frequency;
        for(int i=0;i<strt.length();i++){
            if(strt.charAt(i)=='L') strtL++;
            else if(strt.charAt(i)=='R') strtR++;
            if(target.charAt(i)=='L') targetL++;
            else if(target.charAt(i)=='R') targetR++;
        }
        if(strtL!=targetL || strtR!=targetR) return false;

        int idx=0 , targetIdx=0;
        while(idx<strt.length() && targetIdx<target.length()){
            while(idx<strt.length() && strt.charAt(idx)=='_') idx++;
            while(targetIdx < target.length() && target.charAt(targetIdx)=='_') targetIdx++;
            
            if(idx < strt.length() && targetIdx < target.length()){
                if(strt.charAt(idx)!=target.charAt(targetIdx)) return false;
                
                if ((strt.charAt(idx) == 'L' && idx < targetIdx) || 
                    (strt.charAt(idx) == 'R' && idx > targetIdx)) {
                    return false;
                }
                idx++;
                targetIdx++;
            }
        }
        while(idx < strt.length() && strt.charAt(idx)=='_') idx++;
        while(targetIdx < target.length() && target.charAt(targetIdx)=='_') targetIdx++;
        return idx==targetIdx;
    }
}
