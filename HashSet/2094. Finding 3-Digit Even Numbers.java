class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;

        int[] freq=new int[10];
        for(int num:digits){
            freq[num]++;
        }

        Set<Integer> number=new TreeSet<>();

        for(int num=100 ; num<=998 ;num++){
            if(num%2!=0) continue;
            int a=num/100 , b=(num%100)/10 ,c=num%10;

            int[] currFreq=new int[10];
            currFreq[a]++;
            currFreq[b]++;
            currFreq[c]++;

            boolean isValid=true;
            for(int i=0 ; i <= 9 ;i++){
                if(currFreq[i] > freq[i]){
                    isValid=false;
                    break;
                }
            }

            if(isValid){
                number.add(num);
            }
        }
        int[] ans=new int[number.size()];
        int idx=0;
        for(int num:number){
            ans[idx++]=num;
        }
        return ans;
    }
}
