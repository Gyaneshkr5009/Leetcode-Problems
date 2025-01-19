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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        findRoot(root1 , l1);
        List<Integer> l2=new ArrayList<>();
        findRoot(root2 ,l2);

        return l1.equals(l2);
    }
    private void findRoot(TreeNode root , List<Integer> arr){
        if(root==null) return;
        if(root.left==null && root.right==null) arr.add(root.val);
        else{
            findRoot(root.left , arr);
            findRoot(root.right , arr);
        }
    }
}
