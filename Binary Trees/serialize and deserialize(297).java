/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        
        for(int i = 1; i < nodeValues.length; i++) {
            TreeNode parentNode = queue.poll();
            if (!nodeValues[i].equals("null")) {
                parentNode.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.left);
            }
            if (!nodeValues[++i].equals("null")) {
                parentNode.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.right);
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
