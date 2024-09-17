/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<>();
        //step 1 => create parent root network;
        HashMap<TreeNode , TreeNode> parent=new HashMap<>();
        getParentNode(root , parent);
        //after calling above fuctn we get all modes with their parent;

        HashMap<TreeNode , Boolean> visited=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(target);
        visited.put(target ,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int level=q.size();
            if(curr_level==k) break;
            curr_level++;

            for(int i=0 ;i< level; i++){
                TreeNode node=q.poll();
                if(node.left!=null && !visited.getOrDefault(node.left, false)){
                    q.offer(node.left);
                    visited.put(node.left , true);
                }
                if(node.right!=null && !visited.getOrDefault(node.right, false)){
                    q.offer(node.right);
                    visited.put(node.right , true);
                }
                if(parent.get(node)!=null && !visited.getOrDefault(parent.get(node), false)){
                    q.offer(parent.get(node));
                    visited.put(parent.get(node),true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;

    }
    public void getParentNode(TreeNode root , HashMap<TreeNode , TreeNode>parent){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(root.left!=null){
                q.offer(root.left);
                parent.put(root.left , root);
            }
            if(root.right!=null){
                q.offer(root.right);
                parent.put(root.right , root);
            }
        }
    }
}
