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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){ // for leaf node;
            if(targetSum==root.val) return true;
            else if(targetSum!=root.val) return false;
        }
        if(root.left!=null){
            if(hasPathSum(root.left , targetSum-root.val)) return true;
        }
        if(root.right!=null){
            if(hasPathSum(root.right , targetSum-root.val)) return true;
        }
        return false; 
    }
}
