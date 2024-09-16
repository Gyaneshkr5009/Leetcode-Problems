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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root ,0));

        int first=0 , last=0 , diff=0;
        while(!q.isEmpty()){
            int level=q.size();
            for(int i=0 ;i<level ; i++){
                Pair pair=q.poll();
                TreeNode node=pair.node;
                int pos=pair.position;

                if(i==0) first=pair.position;
                if(i==level-1) last=pair.position;

                if(node.left!=null) q.offer(new Pair(node.left , 2*pos+1));
                if(node.right!=null) q.offer(new Pair(node.right , 2*pos+2));
            }
            diff=Math.max(diff , last-first+1);
        }
        return diff;
    }
}
class Pair{
    TreeNode node;
    int position;
    Pair(TreeNode node , int position){
        this.node=node;
        this.position=position;
    }
}
