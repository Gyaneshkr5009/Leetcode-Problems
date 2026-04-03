//************************************************************************************
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String , Integer> mpp = new HashMap<>();
        
        int stp = 0 , edp=9;
        while(edp < s.length()){
            String temp = s.substring(stp , edp+1);
            mpp.put(temp , mpp.getOrDefault(temp , 0) + 1);
            edp++;
            stp++;
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String , Integer> entry : mpp.entrySet()){
            if(entry.getValue() > 1) ans.add(entry.getKey());
        }
        return ans;
    }
}

//*********************************************(optimized)*************************
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        int stp = 0, edp = 9;

        while (edp < s.length()) {
            String temp = s.substring(stp, edp + 1);

            if (!seen.add(temp)) {
                repeated.add(temp);
            }

            stp++;
            edp++;
        }

        return new ArrayList<>(repeated);
    }
}
