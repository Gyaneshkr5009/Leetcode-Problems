//time complexity:O(n^2);
//space complexity:O(n);

//*********************************************************************************************************************************************
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0) return 0;
        if(!wordList.contains(endWord)) return 0;
        int n=wordList.size();

        Set<String> visited=new HashSet<>();
        for(String s:wordList) visited.add(s);

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord , 1));

        while(!q.isEmpty()){
            Pair pair=q.poll();
            String word=pair.word;
            int length=pair.length;

            for(int i=0 ;i< word.length() ;i++){
                for(char ch='a' ; ch<='z' ;ch++){
                    char[] replaceWordArray=word.toCharArray();
                    replaceWordArray[i]=ch;
                    String replaceWord=new String(replaceWordArray);

                    if(visited.contains(replaceWord)){
                         if(replaceWord.equals(endWord)) return length+1;
                        visited.remove(replaceWord);
                        q.offer(new Pair(replaceWord , length+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String word;
    int length;
    Pair(String word , int length){
        this.word=word;
        this.length=length;
    }
}
