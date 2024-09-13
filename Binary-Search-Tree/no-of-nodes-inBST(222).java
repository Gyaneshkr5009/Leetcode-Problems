//time complexity:O(n);
//****************************************************************************
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        preorder(root);
        return cnt;
    }
    private int cnt=0;
    private void preorder(TreeNode root){
        if(root==null) return;
        cnt++;
        preorder(root.left);
        preorder(root.right);
    }
}
