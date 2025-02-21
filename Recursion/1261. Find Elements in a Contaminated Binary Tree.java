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
class FindElements {
    TreeNode root;
    Set<Integer> st=new HashSet<>();

    public FindElements(TreeNode root) {
        this.root=root;
        root.val=0;
        helper(root);
    }
    private void helper(TreeNode root){
        st.add(root.val);
        if(root.left!=null){
            root.left.val=root.val*2+1;
            helper(root.left);
        }
        if(root.right!=null){
            root.right.val=root.val*2+2;
            helper(root.right);
        }
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
