class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        if(s==null || n==0 || k>n) return 0;

        int cntVowel=0 ,maxCnt=0 ,i=0;

        for(i=0;i<k ;i++){
            if(isVowel(s.charAt(i))) cntVowel++;
        }
        maxCnt=cntVowel;
        int l=0;
        while(i<n){
            char ch=s.charAt(i);
            if(isVowel(ch)) cntVowel++;
            if(isVowel(s.charAt(l))) cntVowel--;
            maxCnt=Math.max(maxCnt , cntVowel);
            l++;
            i++;
        }

        return maxCnt;
    }
    private boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
