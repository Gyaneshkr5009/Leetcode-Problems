//time complexity:O(n);
//space complexity:O(n);

/*approach:
    step1: Use a queue to perform a level-order traversal of the tree.
    step2: Maintain a flag to identify even and odd levels.
    step3: Use a temporary list to collect nodes at each level; reverse the list if the level is even.
    step4: Process and store the reversed nodes for even levels while preserving the order for odd levels.
*/
//****************************************************(bfs traversal)**************************************************************************
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //we can use offer() and poll in queue as well just for the simplicity i used this;
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int flag=0;
        while(!queue.isEmpty()){
            int level=queue.size();
            flag=flag%2;
            List<Integer> list=new ArrayList<>();
            for(int i=0 ;i< level;i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                list.add(queue.remove().val);
            }
            if(flag==1){
                reverse(list);
            }
            flag++;
            ans.add(list);
        }
        return ans;
    }
    private  void reverse(List<Integer> list){
        int stp=0 , edp=list.size()-1;
        while(stp<edp){
            int temp=list.get(stp);
            list.set(stp++ , list.get(edp));
            list.set(edp-- , temp);
        }
    }
}
