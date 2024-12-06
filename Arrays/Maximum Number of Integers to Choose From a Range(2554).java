//time complexity:O(n+m);
//space complexity:O(1);
//***********************************************************************(optimal approach)******************************************
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] bannedNum=new boolean[10001];
        for (int i : banned){
            if(i<=n) bannedNum[i]=true;
        }

        int sum = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(sum + i <= maxSum && !bannedNum[i]){
                sum+=i;
                cnt++;
            }
        }

        return cnt;
    }
}
