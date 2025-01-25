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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        helper(root , root.val , root.val); // root , minValue , maxValue;
        return diff;
    }
    private int diff=0;
    private void helper(TreeNode root, int minValue , int maxValue){
        if(root==null) return ;
        diff=Math.max(diff , Math.max(Math.abs(root.val - minValue) , Math.abs(maxValue-root.val)));
        minValue=Math.min(minValue , root.val);
        maxValue=Math.max(maxValue , root.val);
        helper(root.left , minValue , maxValue);
        helper(root.right , minValue , maxValue);
    }
}
