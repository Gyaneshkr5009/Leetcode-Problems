//time complexity:O(n);
//space complexity:O(1);
//**************************************************************************************************************
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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathsum(root);
        return max;
    }
    public int pathsum(TreeNode root){
        if(root==null) return 0;
        int leftSum=Math.max(0,pathsum(root.left)); // not considering negative one return 0 instead
        int rightSum=Math.max(0 , pathsum(root.right)); // same here
        max=Math.max(max , root.val + leftSum+rightSum);
        return root.val + Math.max(leftSum , rightSum);
    }
}
