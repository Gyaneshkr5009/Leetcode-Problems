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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            int level = st.size();
            for(int i =0 ; i< level ; i++) {
                TreeNode node= st.pop();
                ans.add(node.val);
                if(node.right!=null) st.add(node.right);
                if(node.left!=null) st.add(node.left);
            }
        }
        return ans;
    }
}
