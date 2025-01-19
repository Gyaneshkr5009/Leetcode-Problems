class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int i:nums1) set1.add(i);
        for(int j:nums2) set2.add(j);

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();

        for (int k : set1) {
            if (!set2.contains(k)) {
                l1.add(k);
            }
        }

        for (int k : set2) {
            if (!set1.contains(k)) {
                l2.add(k);
            }
        }

        ans.add(l1);
        ans.add(l2);
        return ans;
    }
}
