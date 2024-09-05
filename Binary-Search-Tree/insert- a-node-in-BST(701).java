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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp=root;
        while(true){
            if(val < temp.val){
                if(temp.left==null){
                    TreeNode newNode=new TreeNode(val);
                    temp.left=newNode;
                    break;
                }
                temp=temp.left;
            }
            else{
                if(temp.right==null){
                    TreeNode newNode=new TreeNode(val);
                    temp.right=newNode;
                    break;
                }
                temp=temp.right;
            }
        }
        return root;
    }
}
