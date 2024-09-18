/*
    *Preorder: [root → left → right]
    *Postorder: [left → right → root]
    *Steps:
      The first element of preorder is the root.
      Use a HashMap to quickly find the position of nodes in postorder.
      The second element in preorder is the left child. Find its position in postorder to determine the size of the left subtree.
      Recursively build:
        Left subtree: From the next part of preorder and the corresponding part of postorder.
        Right subtree: Remaining elements after the left subtree.
    *Key Points:
    Base case: If indices are out of bounds, return null.
    Recursion handles dividing left and right subtrees.
    Time Complexity: O(n)
    Efficient due to the HashMap for quick lookups.
*/
//************************************************************************************************************************************************************************
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
    private HashMap<Integer,Integer> mpp=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder==null || preorder.length==0) return null;
        for(int i=0 ;i<postorder.length ;i++){
            mpp.put(postorder[i] , i);
        }

        return buildTree(preorder , 0 , preorder.length - 1, postorder , 0 , postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder , int preStart , int preEnd , int[] postorder , int pStart ,int pEnd){
        if(preStart>preEnd || pStart > pEnd) return null;

        TreeNode root=new TreeNode(preorder[preStart]);
        if(preStart==preEnd) return root;

        int leftNodeIdx = mpp.get(preorder[preStart+1]);
        int numsLeft = leftNodeIdx-pStart+1;

        root.left=buildTree(preorder ,preStart+1 , preStart + numsLeft , postorder , pStart, leftNodeIdx);
        root.right=buildTree(preorder , preStart + numsLeft +1 , preEnd , postorder , leftNodeIdx+1 , pEnd-1);

        return root;
    }
}
