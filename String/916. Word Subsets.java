//time complexity:O(n*n);
//space complexity:O(n);
//*************************************************************************************************************************************************
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result=new ArrayList<>();
        
        int[] universalFreq=new int[26];
        for(String str:words2){
            int[] temp=new int[26];
            for(char ch:str.toCharArray()){
                temp[ch-'a']++;
                universalFreq[ch-'a']=Math.max(universalFreq[ch-'a'] , temp[ch-'a']);
            }
        }
        //now we have universalFreq array;
        for(String str:words1){
            int[] temp=new int[26];
            for(char ch:str.toCharArray()){
                temp[ch-'a']++;
            }
            if(isSubset(universalFreq , temp)) result.add(str);
        }
        return result;
    }
    private boolean isSubset(int[] freq , int[] temp){
        for(int i=0;i<26;i++){
            if(freq[i]>temp[i]) return false;
        }
        return true;
    }
}
