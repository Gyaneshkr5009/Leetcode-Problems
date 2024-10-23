/*
    Problem Summary:
    
        For each node in a binary tree, replace its value with the sum of the values of all nodes at its level minus the sum of its siblings’ values. Set the root node’s value to 0, as it has no sibling.
    
    Approach:
    
        Edge Case: If the tree is empty, return the root as is.
        Calculate Level Sums: Use BFS traversal to calculate the sum of node values at each level and store it in a list (levelSum).
        Modify Tree Values:
            Traverse the tree again using BFS.
            For each node, subtract the sum of its sibling(s) from the corresponding level sum.
            Set the node's value to the result.
            The root’s value is set to 0 as it has no siblings.
    
    Code Outline:
    
        First BFS: Calculates the sum of values at each level.
        Second BFS: Updates the values of nodes based on their level sum minus their siblings’ values.
*/
/*
    Time Complexity: O(N)
    Space Complexity: O(N)
*/
//*****************************************************************************************************************************************

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        //edge case
        if(root==null) return root;

        //now ist we have to calculate each level sum in a list;
        ArrayList<Integer> levelSum=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>(); //for traversing bredth wise;
        q.offer(root);

        // bfs traversal to store the sum of each level nodes;
        while(!q.isEmpty()){
            int level=q.size();
            int sum=0;
            for(int i=0; i< level ;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            levelSum.add(sum); //adding the level sum into list;
        }

        //now we have to traverse one more time to make changes in our BT by sub the sibling sum from levelSum;
        q.offer(root);
        root.val=0; // as root have no sibling so 0;
        int idx=1; // because root have no sibling so strt for the 2nd level onward;
        while(!q.isEmpty()){
            int level=q.size();
            //moving to its siblings;
            for(int i=0;i<level ;i++){
                TreeNode curr=q.poll();
                int siblingSum=curr.left!=null ? curr.left.val : 0;
                siblingSum+=curr.right!=null ? curr.right.val : 0;

                if(curr.left!=null){
                    curr.left.val=levelSum.get(idx)-siblingSum;
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val=levelSum.get(idx)-siblingSum;
                    q.offer(curr.right);
                }
            }
            idx++;
        }
        return root;
    }
}
