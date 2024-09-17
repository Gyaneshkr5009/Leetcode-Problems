
//***************************************(for understanding do checkout leetcode Problem no=>863 )******************************************
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
    TreeNode startNode;
    public int amountOfTime(TreeNode root, int start) {
        if(root==null) return 0;
        HashMap<TreeNode , TreeNode> parent=new HashMap<>();
        parent(root , parent, start);

        HashMap<TreeNode , Boolean> visited=new HashMap<>();
        visited.put(startNode , true);

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(startNode);
        int time=0;

        while(!q.isEmpty()){
            int size=q.size();
            time++;
            for(int i=0 ;i<size ;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    visited.put(curr.left ,true);
                    q.offer(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    visited.put(curr.right , true);
                    q.offer(curr.right);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    visited.put(parent.get(curr) ,true);
                    q.offer(parent.get(curr));
                }
            }
        }

        //time-1 because loop time got count for checking leaf node that have null left and null right node;
        return time-1;
    }
    private void parent(TreeNode root , HashMap<TreeNode ,  TreeNode> parent , int start){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val==start) startNode=curr;
            if(curr.left!=null){
                q.offer(curr.left);
                parent.put(curr.left , curr);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                parent.put(curr.right , curr);
            }
        }
    }
}
