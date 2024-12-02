//time complexity:O(n);
//space complexity:O(n);
//****************************************************************************************************************************************
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if(searchWord==null || sentence==null || searchWord.length()==0 || sentence.length()==0) return -1;
        String[] words=sentence.split(" ");

        int idx=Integer.MAX_VALUE;
        for(int i=0;i<words.length ;i++){
            String word=words[i];
            if(word.startsWith(searchWord)) idx=Math.min(idx , i);
        }
        if(idx==Integer.MAX_VALUE) return -1;
        else return idx+1;
    }
}

//*****************************************************************(optimal approach)*************************************************
//time complexity:O(n);
//space complexity:O(1);
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if(searchWord==null || sentence==null || searchWord.length()==0 || sentence.length()==0) return -1;

        int wordIdx=1; // for word count
        int charIdx=0; // for 
        while(charIdx< sentence.length()){
            int searchCharIdx=0;
            boolean isPrefix=true;

            while(charIdx<sentence.length() && sentence.charAt(charIdx)!=' '){
                if(searchCharIdx<searchWord.length()){
                    if(sentence.charAt(charIdx) == searchWord.charAt(searchCharIdx)) searchCharIdx++;
                    else isPrefix=false;
                }
                charIdx++;
            }

            if (isPrefix && searchCharIdx == searchWord.length()) return wordIdx;
            // if the space occured just skipping that iteration and checking for new word;
            charIdx++;
            wordIdx++;
        }
        return -1;
    }
}
