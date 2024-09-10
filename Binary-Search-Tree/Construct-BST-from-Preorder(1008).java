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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder ==null || preorder.length==0) return new TreeNode();
        TreeNode root=createBST(preorder[0] , null);
        for(int i=1 ;i<preorder.length ;i++){
            createBST(preorder[i],root);
        }
        return root;
    }
    private TreeNode createBST(int val , TreeNode root){
        if(root==null) return new TreeNode(val);
        if(root.val < val){
            root.right=createBST(val ,root.right);
        }
        else{
            root.left=createBST(val ,root.left);
        }
        return root;
    }
}
