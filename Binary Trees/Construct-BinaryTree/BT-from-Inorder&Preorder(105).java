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
    private HashMap<Integer ,Integer> mpp=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null || inorder.length==0) return new TreeNode();
        for(int i=0 ;i<inorder.length ;i++){
            mpp.put(inorder[i] , i);
        }
        return helper(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);
        
    }
    private TreeNode helper(int[] preorder , int pstart , int pend , int[] inorder , int instart , int inend){
        if(pstart > pend || instart>inend) return null;

        TreeNode root = new TreeNode(preorder[pstart]);
        int parentRootIdx=mpp.get(preorder[pstart]);
        int numsLeft=parentRootIdx - instart;

        root.left=helper(preorder , pstart+1 , pstart + numsLeft , inorder , instart , parentRootIdx-1);
        root.right=helper(preorder , pstart+numsLeft+1, pend , inorder , parentRootIdx + 1, inend );
        return root;
    }
}
