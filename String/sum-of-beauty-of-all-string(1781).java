//time complexity:O(n^3);
//space complexity:O(1);
//*****************************************************************************(brute force)********************************************************************
class Solution {
    public int beautySum(String s) {
        if(s==null || s.length() == 0) return 0;
        int n=s.length();
        int sum=0;
        int min=Integer.MAX_VALUE , max=Integer.MIN_VALUE;
        for(int i=0 ;i<n ;i++){
            int[] freq=new int[26];
            for(int j=i ; j< n ;j++){
                freq[s.charAt(j)-'a']++;
                min=getMin(freq);
                max=getMax(freq);
                sum+=max-min;
            }
            
        }
        return sum;
    }
    private int getMax(int freq[]){
        int max=Integer.MIN_VALUE;
        for(int n:freq){
            max=Math.max(max , n);
        }
        return max;
    }
    private int getMin(int[] freq){
        int min=Integer.MAX_VALUE;
        for(int n: freq){
            if(n!=0)
            min=Math.min(min , n);
        }
        return min;
    }
}


//**********************************************************************(optimal approach 1)******************************************************************
//time and space still the same as above; but slightly better because we dont create extra fuctns for solving min max;
class Solution {
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int [] freq=new int [26];
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]>0){
                        min=Math.min(min,freq[k]);
                        max=Math.max(max,freq[k]);
                    }
                }
                ans+=max-min;
            }
        }
        return ans;
    }
}

//**********************************************************************(optimal approach 2)******************************************************************
//time complexity:O(n^2)
//space somplexity:O(1)

class Solution {
    public int beautySum(String s) {
        int size = s.length();
        char[] str = s.toCharArray();
        int count = 0;
        for(int left = 0; left < size; left++){
            int[] map = new int[26];
            map[str[left] - 'a']++;
            int[] freq = new int[size + 1];
            freq[1] = 1;
            int max = 1;
            int min = 1;
            for(int right = left + 1; right < size; right++){
                int i = str[right] - 'a';
                map[i]++;
                freq[map[i] - 1]--;
                freq[map[i]]++;
                if(map[i] > max){
                    max = map[i];
                }
                if(map[i] == 1){
                    min = 1;
                }
                if(freq[min] == 0) min = map[i];
                count += (max - min);
            }
        }
        return count;
    }
}
