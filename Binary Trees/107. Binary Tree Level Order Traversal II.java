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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> bfs=new ArrayList<>();
        if(root==null) return bfs;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> sublevels=new ArrayList<>();
            for(int i=0;i<level ;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null) q.add(q.peek().right);
                sublevels.add(q.remove().val);
            }
            bfs.add(sublevels);
        }
        Collections.reverse(bfs);
        return bfs;
    }
}
