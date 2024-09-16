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

    //TreeMap< X-axis , TreeMap<y-axis , sorted<TreeNode.val> >>;
    TreeMap<Integer , TreeMap<Integer , ArrayList<Integer> >> mpp=new TreeMap<>();
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null) return ans;
        compute(root , 0 ,0);

        for(Map.Entry<Integer,TreeMap<Integer , ArrayList<Integer>>> outer: mpp.entrySet()){
            for(Map.Entry<Integer, ArrayList<Integer>> inner:outer.getValue().entrySet()){
                Collections.sort(inner.getValue());
            }
        }

        for(Map.Entry<Integer,TreeMap<Integer , ArrayList<Integer>>> outer: mpp.entrySet()){
            List<Integer> temp=new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> inner:outer.getValue().entrySet()){
                temp.addAll(inner.getValue());
            }
            ans.add(temp);
        }
        return ans;
    
    }
    public void compute(TreeNode root , int xAxis , int yAxis){
        if(root==null) return ;
        mpp.putIfAbsent(xAxis , new TreeMap<>());
        mpp.get(xAxis).putIfAbsent(yAxis , new ArrayList<Integer>());
        mpp.get(xAxis).get(yAxis).add(root.val);
        compute(root.left , xAxis-1 , yAxis+1);
        compute(root.right , xAxis+1 , yAxis+1);
    }
}
