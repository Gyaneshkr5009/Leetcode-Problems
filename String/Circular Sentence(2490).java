//time complexity:O(n);
//space complexity:O(n);
//**************************************************************************************************************************************
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words=sentence.split(" "); // this will split all words from then sentences;
        int n=words.length;

        if (words[0].charAt(0) != words[n-1].charAt(words[n-1].length() - 1)) return false;
        String prev=words[0];

        for(int i=1;i<words.length ;i++){
            String curr=words[i];
            int l=prev.length();
            if(curr.charAt(0) != prev.charAt(l-1)) return false;
            prev=curr;
        }
        return true;
    }
}

//************************************************************************(better approach)***********************************************************
class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence==null || sentence.length()==0) return false;
        int n =sentence.length();

        if(sentence.charAt(0) != sentence.charAt(n-1)) return false;

        for(int i=1; i<n ;i++){
            if(sentence.charAt(i) == ' '){
                if(sentence.charAt(i-1) != sentence.charAt(i+1)) return false;
            }
        }
        return true;
    }
}
