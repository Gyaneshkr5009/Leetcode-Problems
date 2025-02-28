int len=dp[n][m];
    int i=n;
    int j=m;
    
    int index = len-1;
    String str="";
    for(int k=1; k<=len;k++){
        str +="$"; // dummy string
    }
    StringBuilder ss= new StringBuilder(s1);
    StringBuilder str2=new StringBuilder(str);
    while(i>0 && j>0){
        if(ss.charAt(i-1) == s2.charAt(j-1)){
            str2.setCharAt(index,ss.charAt(i-1) ); 
            index--;
            i--;
            j--;
        }
        else if(ss.charAt(i-1)>s2.charAt(j-1)){
            i--;
        }
        else j--;
    }
    System.out.println(str2);
