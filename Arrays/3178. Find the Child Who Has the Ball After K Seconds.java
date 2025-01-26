class Solution {
    public int numberOfChild(int n, int k) {
        int dir=1; // 1->right -1->left
        int children=0;
        while(k-- > 0){
            children+=dir;
            if(children==n-1 || children==0) dir=-dir;
        }
        return children;
    }
}
