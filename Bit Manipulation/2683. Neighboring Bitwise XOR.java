//time complexity:O(n)
//space complexity:O(1)
//****************************************************************************************************
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        //x=y⊕z⟺
        //x⊕y=y⊕z⊕y=z
        if(derived==null || derived.length==0) return false;
        int n=derived.length;

        int res=0;

        for (int num:derived) {
            res^=num;
        }
        return res == 0;
    }
}

//*********************************************************************************************************
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if(derived==null || derived.length==0) return false;
        int n=derived.length;

        int[] arr=new int[n];

        for (int i = 1; i < n; i++) {
            arr[i] = derived[i - 1] ^ arr[i - 1];
        }
        return (arr[n - 1] ^ derived[n - 1]) == arr[0];
    }
}
