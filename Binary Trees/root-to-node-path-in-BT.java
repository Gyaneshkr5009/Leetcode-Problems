class Solution {
     public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        PathUtil(root,result,new ArrayList<>());
        return result;
        
    }
    public static void PathUtil(Node root , ArrayList<ArrayList<Integer>> result , ArrayList<Integer> sub){
        if(root==null){
            return;
        }
        sub.add(root.data);
        if(root.left==null && root.right==null){
            result.add(new ArrayList<>(sub));
        }
        PathUtil(root.left,result,sub);
        PathUtil(root.right,result,sub);
        sub.remove(sub.size()-1);
    }
}
