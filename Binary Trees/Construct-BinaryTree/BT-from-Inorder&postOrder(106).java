/*
  Inorder: [left → root → right]
  Postorder: [left → right → root]
Steps:
  The last element of postorder is the root.
  Use a HashMap to quickly find the root’s index in inorder.
  Calculate the number of nodes in the left subtree using the root’s index in inorder.
Recursively build:
  Left subtree: From the left portion of both inorder and postorder.
  Right subtree: From the remaining portion after the left subtree.
Key Points:
  Base case: If indices are out of bounds, return null.
  Recursion divides the tree into left and right subtrees.
Time Complexity: O(n)
  Efficient due to the use of a HashMap for fast lookups.
*/
//******************************************************************************************************************************************************
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
    private HashMap<Integer, Integer> mpp = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;

        // Store the index of each value in the inorder array for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            mpp.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd) return null;

        // Root is the last element in the current postorder segment
        TreeNode root = new TreeNode(postorder[pEnd]);

        // Find the index of the root in the inorder array
        int parentNodeIdx = mpp.get(root.val);
        
        // Number of elements in the left subtree
        int numsLeft = parentNodeIdx - inStart;

        // Build the left subtree
        root.left = buildTree(inorder, inStart, parentNodeIdx - 1, postorder, pStart, pStart + numsLeft - 1);

        // Build the right subtree
        root.right = buildTree(inorder, parentNodeIdx + 1, inEnd, postorder, pStart + numsLeft, pEnd - 1);

        return root;
    }
}
