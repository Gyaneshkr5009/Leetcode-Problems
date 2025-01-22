class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return ans;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        if (prev != null) ans = Math.min(ans, Math.abs(node.val - prev.val));
        prev = node;        
        helper(node.right);
    }
}
