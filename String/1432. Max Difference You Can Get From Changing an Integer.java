class Solution {
    public int maxDiff(int num) {
        String s=String.valueOf(num);
        int n=s.length();

        String maxStr=new String(s);
        int i=0;
        while(i < n && s.charAt(i) == '9') i++;

        if(i<n){
            maxStr=s.replace(s.charAt(i) , '9');
        }
        int maxValue=Integer.parseInt(maxStr);

        //now we have to find the minimum number;
        int minValue=num;
        for(char replace : new char[]{'0' , '1'}){
            for(int j=0; j<n;j++){
                if(s.charAt(j) == replace) continue;

                String temp=s.replace(s.charAt(j) , replace);
                if(temp.charAt(0) != '0'){
                    minValue = Math.min(minValue, Integer.parseInt(temp));
                }
            }
        }
        return maxValue - minValue;
    }
}
