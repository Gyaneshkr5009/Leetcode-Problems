//time complexity:O(n);
//space complexity:O(1);
//************************************************************************************************************************************
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //checking if both are null if yes means same;
        if(p==null && q==null) return true;
        //now we check if the both queue value are same or not  and also their  childrens;
        if(p!=null && q!=null && p.val==q.val){
            //&& operator confirms if both recursion are true then return true;
            return isSameTree(p.right ,q.right) && isSameTree(p.left ,q.left);
        }
        return false;
    }
}
