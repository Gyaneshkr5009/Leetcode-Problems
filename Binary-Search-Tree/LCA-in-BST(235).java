//institution if we got both p and q move left same goes for right if both large
//once we get the divergion where p and q value are both lies in opposite side means curr root is the ancestor;
//********************************************************************************************************************
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val > p.val && root.val >q.val) return lowestCommonAncestor(root.left ,p ,q);
        else if(root.val <p.val && root.val < q.val) return lowestCommonAncestor(root.right ,p ,q);
        else return root;
    }
}
