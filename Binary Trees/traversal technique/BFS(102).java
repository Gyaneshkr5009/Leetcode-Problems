/*
    Initialize: Create an empty list for BFS results and a queue for level-order traversal. Add the root node to the queue.
    Process Levels: While the queue is not empty, determine the number of nodes at the current level. Initialize a list to store node values for this level.
    Traverse Nodes: For each node at the current level, add its children to the queue and collect its value.
    Store Results: Add the list of values from the current level to the BFS results list.
*/
//time complexity:O(n)
//space complexity:O(n)

//***********************************************************************************************************************************

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
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return bfs;
    }
}
