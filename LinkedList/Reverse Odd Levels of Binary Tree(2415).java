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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return root;
        //declaring queue for bfs traversal;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<TreeNode> reverse=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(level%2==1) reverse.add(node);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            if(level%2==1){
                int left=0 , right=reverse.size()-1;
                while(left<right){
                    int temp=reverse.get(left).val;
                    reverse.get(left).val=reverse.get(right).val;
                    reverse.get(right).val=temp;
                    right--;
                    left++;
                }
            }
            level++;
        }
        return root;
    }
}
