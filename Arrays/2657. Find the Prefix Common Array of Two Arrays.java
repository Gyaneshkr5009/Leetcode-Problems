class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean[] freqA=new boolean[60];
        boolean[] freqB=new boolean[60];

        int[] result=new int[A.length];

        for(int i=0 ;i<A.length ;i++){
            int common=0;
            freqA[A[i]]=true;
            freqB[B[i]]=true;
            for(int j=0;j<=i;j++){
                if(freqA[A[j]] && freqB[A[j]]) common++;
            }
            result[i]=common;
        }
        return result;
    }
}

//****************************************************************(optimized approach)***********************************************
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq=new int[51];

        int[] result=new int[A.length];

        int common=0;
        for(int i=0 ;i<A.length ;i++){
            freq[A[i]]++;
            if(freq[A[i]]==2) common++;
            freq[B[i]]++;
            if(freq[B[i]]==2) common++;
            result[i]=common;
        }
        return result;
    }
}
