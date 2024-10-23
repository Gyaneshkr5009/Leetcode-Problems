/*
    Revision Notes:

    Perform BFS level-wise traversal using a queue.
    Track the sum of node values at each level.
    Keep track of the level with the maximum sum.
    Update the answer when a higher sum is found.

    Time Complexity: O(N) - where N is the number of nodes (each node is visited once). 
    Space Complexity: O(W) - where W is the maximum width of the tree (queue size at the widest level).
*/
//*****************************************************************************************************************************************
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;

        //for traversing breadth wise;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int levelSum=Integer.MIN_VALUE;
        int level=0; // this represent the level of Bt;
        int ans=1; // this ans contain the level;
        while(!q.isEmpty()){
            int levelSize=q.size();
            int sum=0;
            level++;
            for(int i=0;i<levelSize;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            if(sum>levelSum){
                levelSum=sum;
                ans=level;
            }
        }

        return ans;
    }
}
