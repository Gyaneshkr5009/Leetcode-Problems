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
    TreeNode first;
    TreeNode second;
    TreeNode third;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        first=second=third=null;
        helper(root);
        if(first!=null && third!=null){
            int temp=first.val;
            first.val=third.val;
            third.val=temp;
        }
        else if(first!=null && second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
        
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
                second=root;
            }
            else{
                third=root;
            }
        }
        prev=root;
        helper(root.right);
    }

    

}
